package com.zextras.proxyconfgen;

import com.zimbra.common.service.ServiceException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

class ProxyConfUtil {

  private ProxyConfUtil() {}

  public static void writeContentToFile(String content, String filePath) throws ServiceException {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath)); ) {
      bw.write(content);
    } catch (IOException e) {
      throw ServiceException.FAILURE(
          "Cannot write the content (" + content + ") to " + filePath, e);
    }
  }

  public static boolean isEmptyString(String target) {
    return (target == null) || (target.trim().equalsIgnoreCase(""));
  }

  public static InetAddress getLookupTargetIPbyIPMode(String hostname) throws com.zextras.proxyconfgen.ProxyConfException {

    InetAddress[] ips;
    try {
      ips = InetAddress.getAllByName(hostname);
    } catch (UnknownHostException e) {
      throw new com.zextras.proxyconfgen.ProxyConfException("the lookup target " + hostname + " can't be resolved");
    }
    com.zextras.proxyconfgen.IPModeEnablerVar.IPMode mode = com.zextras.proxyconfgen.IPModeEnablerVar.getZimbraIPMode();

    if (mode == com.zextras.proxyconfgen.IPModeEnablerVar.IPMode.IPV4_ONLY) {
      for (InetAddress ip : ips) {
        if (ip instanceof Inet4Address) {
          return ip;
        }
      }
      throw new com.zextras.proxyconfgen.ProxyConfException(
          "Can't find valid lookup target IPv4 address when zimbra IP mode is IPv4 only");
    } else if (mode == com.zextras.proxyconfgen.IPModeEnablerVar.IPMode.IPV6_ONLY) {
      for (InetAddress ip : ips) {
        if (ip instanceof Inet6Address) {
          return ip;
        }
      }
      throw new com.zextras.proxyconfgen.ProxyConfException(
          "Can't find valid lookup target IPv6 address when zimbra IP mode is IPv6 only");
    } else {
      for (InetAddress ip : ips) {
        if (ip instanceof Inet4Address) {
          return ip;
        }
      }
      return ips[0]; // try to return an IPv4, but if there is none,
      // simply return the first IPv6
    }
  }
}
