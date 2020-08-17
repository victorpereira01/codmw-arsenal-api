package com.victorpereira.codmwarsenal.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.victorpereira.codmwarsenal.models.Weapon;

public class Utils {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static void updateData(Weapon oldData, Weapon newData) {
		oldData.setName(newData.getName());
		oldData.setType(newData.getType());
		oldData.setChestDmg(newData.getChestDmg());
		oldData.setMagSize(newData.getMagSize());
		oldData.setAdsSpeed(newData.getAdsSpeed());
		oldData.setChestDps(newData.getChestDps());
		oldData.setRpm(newData.getRpm());
		oldData.setBaseRange(newData.getBaseRange());
	}
}
