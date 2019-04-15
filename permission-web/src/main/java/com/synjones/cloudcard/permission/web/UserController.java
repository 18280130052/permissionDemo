package com.synjones.cloudcard.permission.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.synjones.cloudcard.permission.provider.common.CommonArgs;
import com.synjones.cloudcard.permission.provider.facade.PermissionProvider;
import com.synjones.cloudcard.permission.provider.models.MngUserRo;
import com.synjones.common.share.request.BasePageRequest;
import com.synjones.common.share.response.BasePageResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {
    @Reference
    private PermissionProvider permissionProvider;

    @RequestMapping("/user")
    public BasePageResponse<MngUserRo> getUser(BasePageRequest<MngUserRo> req, CommonArgs args){
        return permissionProvider.listUser(req, args);
    }

    @RequestMapping("/imgCode")
    public void CreateCode(HttpServletRequest req, HttpServletResponse resp){
        //生成随机数
        String randomCode = UUID.randomUUID().toString().substring(0, 5);

        //把随机数放进Session中 以当前用户名为key
        req.getSession().setAttribute("rCode", randomCode);

        //创建图片对象
        int width = 100;
        int height = 40;
        int imageType = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(width, height, imageType);

        //画板
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        //绘制一个实心的矩形
        g.fillRect(1, 1, width - 2, height - 2);

        //把随机数画进图片中
        g.setColor(Color.BLACK);//设置随机数的颜色
        Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 20);
        g.setFont(font);//设置随机数的字体和大小
        g.drawString(randomCode, 10, 28);
        //干扰线
        g.setColor(Color.GRAY);
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
        }

        //关闭
        g.dispose();
        //System.out.println("验证码--"+req.getSession().getAttribute("rCode"));
        //把图片对象以流的方式保存出去
        try {
            ImageIO.write(image, "jpg", resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
