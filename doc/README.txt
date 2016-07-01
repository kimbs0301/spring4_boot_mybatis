이클립스 VM arguments
-server -Xms256m -Xmx256m -XX:+UseG1GC -XX:+UnlockDiagnosticVMOptions -XX:InitiatingHeapOccupancyPercent=35 -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=local

cd /workspace/luna/spring4_boot_mybatis
git add -A
git commit -a -m "ok"
git push



create database mybatis_data;

use mybatis_data;

CREATE TABLE mybatis_data.`account` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `value` int(11) NOT NULL,
  `crt_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



http://www.mybatis.org/spring/getting-started.html
