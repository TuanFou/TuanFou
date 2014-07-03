package com.tuanfou.utils;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.hibernate.Query;

import com.google.gson.Gson;


/**
 * A generic method which is used to transform List<T> into a string,
 * and this is used to test.
 * @author yogiman
 *
 */
public class GsonTestTemplate {
	public static <T> void testListToString(List<T> list){
		Gson gson = new Gson();
		String string =  gson.toJson(list);
		System.out.println(string);
	}
}
