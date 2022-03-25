package org.pettyfox.base.event;


public class PackagePettyTool {

    /**
     * @param packageName 完整包名
     * @param showLen     显示长度
     * @return 包名格式化，美化包名过长
     */
    public static String packagePetty(String packageName, int showLen) {
        if (packageName.length() <= showLen) {
            return packageName;
        }
        String[] list = packageName.split("\\.");
        int len = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1) {
                sb.append(list[i]);
            } else {
                if (list[i].length() == 0) {
                    continue;
                }
                sb.append(list[i], 0, 1).append(".");
            }
        }
        return sb.length() <= showLen ? sb.toString() : sb.substring(sb.length() - showLen, sb.length());
    }

    public static String packagePetty(String packageName) {
        return packagePetty(packageName, 40);
    }

    public static void main(String[] args) {
        System.out.println(PackagePettyTool.packagePetty("com.pef.nihao.asdfas...Nhao"));
    }
}
