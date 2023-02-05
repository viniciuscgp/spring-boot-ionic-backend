package br.app.narede.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	public static List<Integer> decodeIntList(String s)
	{
		List<Integer> listaInt = new ArrayList<>();
		String[] partes = s.split(",");
		for (String part:partes) {
			listaInt.add(Integer.valueOf(part));
		}
		
		return listaInt;
		
		//return Arrays.asList(s.split(",")).stream().map(x->Integer.parseInt(x)).collect(Collectors.toList());
	}
	
	public static String decodeParam(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
