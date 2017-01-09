package com.adnonstop.okhttputils.impl;

import java.util.List;
import java.util.Map;

/**
 * Created by gzq on 2017/1/9.
 */

public interface OKCallback {
    void onSuccessBody(String data);

    void onSuccessHeaders(Map<String, List<String>> headers);

    void onFail(Exception e);
}
