package com.example.mycustonchartview.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	/**
	 * @方法说明:加载布局文件
	 * @方法名称:LoadXmlView
	 * @param con
	 * @param resouce_Id
	 * @return
	 * @返回�View
	 */
	public static View LoadXmlView(Context con, int resouce_Id) {
		LayoutInflater flat = LayoutInflater.from(con);
		View view = flat.inflate(resouce_Id, null);
		return view;
	}

	/**
	 * @方法说明:
	 * @方法名称:getDisPlayMetrics
	 * @param context
	 * @return
	 * @返回�DisplayMetrics
	 */
	public static DisplayMetrics getDisPlayMetrics(Context context) {
		DisplayMetrics metric = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay()
				.getMetrics(metric);
		return metric;
	}

	/**
	 * @方法说明:获取屏幕的宽度（像素� * @方法名称:getScreenWidth
	 * @param context
	 * @return
	 * @返回�int
	 */
	public static int getScreenWidth(Context context) {
		int width = getDisPlayMetrics(context).widthPixels;
		return width;
	}

	/**
	 * @方法说明:获取屏幕的高� * @方法名称:getScreenHeight
	 * @param context
	 * @return
	 * @返回�int
	 */
	public static int getScreenHeight(Context context) {
		int height = getDisPlayMetrics(context).heightPixels;
		return height;
	}

	/**
	 * @方法说明:根据手机的分辨率从dp的单位转成px(像素)
	 * @方法名称:diptopx
	 * @param context
	 * @param dpValue
	 * @return
	 * @返回�int
	 */
	public static int diptopx(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * @方法说明:Test whether is Mobile phone number
	 * @方法名称:isMobileNO
	 * @param mobiles
	 * @return
	 * @返回�boolean
	 */
	public static boolean isMobileNO(String mobiles) {
		if (isNotEmpty(mobiles)) {
			Pattern p = Pattern
					.compile("^(1[0-9])\\d{9}$");
			Matcher m = p.matcher(mobiles);
			return m.matches();
		} else
			return false;
	}

	/**
	 * @方法说明:验证字符串为� * @方法名称:isNotEmpty
	 * @param str
	 * @return
	 * @返回�Boolean
	 */
	public static Boolean isNotEmpty(String str) {
		if (null != str && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

}
