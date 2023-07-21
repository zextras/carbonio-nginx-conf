// SPDX-FileCopyrightText: 2023 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: AGPL-3.0-only

package com.zextras.proxyconfgen;



import com.zimbra.cs.mailbox.MailboxTestUtil;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProxyConfGenIT {

  @BeforeAll
  public static void setUpAll() throws Exception {
    MailboxTestUtil.initServer();
  }

  @Test
  void shouldDeleteCertbotCertificatesWhenDomainNotExisting() throws Exception{
    final String path = ProxyConfGen.class.getClassLoader().getResource("opt/zextras").getPath();
    final String domainName = "test.com";

    final File leDir = new File(Path.of(path + File.separator
            + "/common/certbot/etc/letsencrypt/live/", domainName).toString());
    leDir.mkdirs();

    final File certificate = new File(Path.of(leDir.toString(), ProxyConfGen.CERT).toString());
    final File privateKey = new File(Path.of(leDir.toString(), ProxyConfGen.KEY).toString());

    certificate.createNewFile();
    privateKey.createNewFile();

    ProxyConfGen.createConf(new String[]{"-w", path});

    final File certbotFilesDir = new File(
        Path.of(ProxyConfGen.getCertbotWorkingDir(), domainName).toString());
    Assertions.assertFalse(certbotFilesDir.exists());

  }



}