package com.zextras.proxyconfgen;

class HttpEnablerVar extends com.zextras.proxyconfgen.WebEnablerVar {

  public HttpEnablerVar() {
    super(
        "web.http.enabled",
        true,
        "Indicates whether HTTP Proxy will accept connections on HTTP "
            + "(true unless zimbraReverseProxyMailMode is 'https')");
  }

  @Override
  public void update() {
    String mailmode = getZimbraReverseProxyMailMode();
    if ("https".equalsIgnoreCase(mailmode)) {
      mValue = false;
    } else {
      mValue = true;
    }
  }
}
