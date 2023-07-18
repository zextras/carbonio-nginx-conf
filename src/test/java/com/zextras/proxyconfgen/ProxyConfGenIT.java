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
import org.junit.jupiter.api.io.TempDir;

class ProxyConfGenIT {
  @BeforeAll
  public static void setUpAll() throws Exception {
    MailboxTestUtil.initServer();
  }

  @TempDir
  File proxyWorkingDir;

  @Test
  void shouldDeleteCertbotCertificatesWhenDomainNotExisting() throws Exception{
    final String domainName = "test.com";
    final File leDir = new File(
        Path.of(proxyWorkingDir.getAbsolutePath() + File.separator
            + "/common/certbot/etc/letsencrypt/live/", domainName).toUri());
    new File(Path.of(proxyWorkingDir.getAbsolutePath() , "conf/nginx/templates").toUri()).mkdirs();
    leDir.mkdirs();


    final File certificate = new File(Path.of(leDir.getAbsolutePath(), ProxyConfGen.CERT).toString());
    final File privateKey = new File(Path.of(leDir.getAbsolutePath(), ProxyConfGen.KEY).toString());
    final File nginxTemplateFile = new File(Path.of(proxyWorkingDir.getAbsolutePath() , "conf/nginx/templates",
        "nginx.conf.template").toString());

    certificate.createNewFile();
    privateKey.createNewFile();
    nginxTemplateFile.createNewFile();

    ProxyConfGen.main(new String[]{"-w", proxyWorkingDir.getAbsolutePath()});

    final File certbotFilesDir = new File(
        Path.of(ProxyConfGen.getCertbotWorkingDir(), domainName).toUri());
    Assertions.assertFalse(certbotFilesDir.exists());


  }



}