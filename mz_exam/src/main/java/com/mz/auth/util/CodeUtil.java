package com.mz.auth.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeUtil {

    // 验证码字符集合
    private static final String CODE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // 验证码图片的宽度
    private static final int WIDTH = 100;

    // 验证码图片的高度
    private static final int HEIGHT = 40;

    // 验证码字符个数
    private static final int CODE_LENGTH = 4;

    // 干扰线数量
    private static final int LINE_COUNT = 20;

    // 随机数生成器
    private static final Random random = new Random();

    /**
     * 生成验证码和验证码图片的方法
     *
     * @return 包含验证码字符串和验证码图片的Map对象
     */
    public static Map<String, Object> generateCodeAndPic() {
        // 创建空白的图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics graphics = image.getGraphics();

        // 设置背景色
        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体
        graphics.setFont(new Font("Times New Roman", Font.PLAIN, 28));

        // 生成随机验证码
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            char charCode = CODE_CHARS.charAt(random.nextInt(CODE_CHARS.length()));
            code.append(charCode);
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            graphics.drawString(String.valueOf(charCode), (i * (WIDTH / CODE_LENGTH)) + 10, HEIGHT / 2 + 10);
        }

        // 生成干扰线
        for (int i = 0; i < LINE_COUNT; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(5);
            int y2 = random.nextInt(5);
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
        }

        // 关闭图形上下文
        graphics.dispose();

        // 创建包含验证码字符串和验证码图片的Map对象
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code.toString());
        codeMap.put("codePic", image);

        return codeMap;
    }
}