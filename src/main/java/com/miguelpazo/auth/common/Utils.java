package com.miguelpazo.auth.common;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public String generateToken(int size, Boolean hexa) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[size];
        random.nextBytes(bytes);
        String token;

        if (hexa) {
            token = bytesToHex(bytes).toLowerCase();
        } else {
            Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
            token = encoder.encodeToString(bytes);
        }

        return token;
    }

    public String hash(String data) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha256.digest(data.getBytes());

            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }

    public String getUtcFormat(Long timestamp) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            format.setTimeZone(TimeZone.getTimeZone("UTC"));

            return format.format(timestamp);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }

    public String readFileFromResources(String file) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(file);
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());

            return writer.toString();
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }

    public void saveToFile(String data, String path) {
        try {
            File newTextFile = new File(path);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(data);
            fw.close();
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
