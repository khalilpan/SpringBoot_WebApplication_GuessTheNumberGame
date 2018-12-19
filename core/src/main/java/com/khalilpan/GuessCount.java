package com.khalilpan;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD ,ElementType.PARAMETER,ElementType.METHOD}) // defines the types of annotations
@Retention(RetentionPolicy.RUNTIME) // define lifeCycle of elements
@Qualifier
public @interface GuessCount {



}
