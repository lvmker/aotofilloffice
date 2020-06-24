package com.bgi.ms.engine.base.method;

public @interface BaseParameter {
	String name();
	String from() default "applicationParams";
	String ext() default "";
}
