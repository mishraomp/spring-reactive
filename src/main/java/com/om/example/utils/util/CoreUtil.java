package com.om.example.utils.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.URLEncoder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoreUtil {

  public static String encodeString(String clientName) {
    try {
      return URLEncoder.encode(clientName, "utf-8");
    } catch (Exception e) {
      return clientName;
    }
  }

}
