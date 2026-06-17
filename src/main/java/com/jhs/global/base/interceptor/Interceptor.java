package com.jhs.global.base.interceptor;

import com.jhs.global.base.rq.Rq;

public interface Interceptor {
  boolean run(Rq rq);
}
