package io.zbc.price.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class LinuxInfoUtil {

    private static final Logger logger = LoggerFactory.getLogger(LinuxInfoUtil.class);

    public static String getIp() {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                        //获得IP
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipAddress = inetAddress.getHostAddress().toString();
                            if (!ipAddress.contains("::")
                                    && !ipAddress.contains("0:0:")
                                    && !ipAddress.contains("fe80")
                                    && !"127.0.0.1".equals(ip)) {
                                ip = ipAddress;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("get current ip failed.", e);
            ip = null;
        }
        return ip;
    }

}
