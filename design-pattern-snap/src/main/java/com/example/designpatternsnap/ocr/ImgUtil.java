package com.example.designpatternsnap.ocr;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImgUtil {

    public static void removeBackground(String imgUrl, String resUrl){
        //定义一个临界阈值
        int threshold = 300;
        try{
            BufferedImage img = ImageIO.read(new File(imgUrl));
            int width = img.getWidth();
            int height = img.getHeight();
            for(int i = 1;i < width;i++){
                for (int x = 0; x < width; x++){
                    for (int y = 0; y < height; y++){
                        Color color = new Color(img.getRGB(x, y));
                        System.out.println("red:"+color.getRed()+" | green:"+color.getGreen()+" | blue:"+color.getBlue());
                        int num = color.getRed()+color.getGreen()+color.getBlue();
                        if(num >= threshold){
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
            for(int i = 1;i<width;i++){
                Color color1 = new Color(img.getRGB(i, 1));
                int num1 = color1.getRed()+color1.getGreen()+color1.getBlue();
                for (int x = 0; x < width; x++)
                {
                    for (int y = 0; y < height; y++)
                    {
                        Color color = new Color(img.getRGB(x, y));
 
                        int num = color.getRed()+color.getGreen()+color.getBlue();
                        if(num==num1){
                            img.setRGB(x, y, Color.BLACK.getRGB());
                        }else{
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
            File file = new File(resUrl);
            if (!file.exists())
            {
                File dir = file.getParentFile();
                if (!dir.exists())
                {
                    dir.mkdirs();
                }
                try
                {
                    file.createNewFile();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            ImageIO.write(img, "jpg", file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void cuttingImg(String imgUrl){
        try{
            File newfile=new File(imgUrl);
            BufferedImage bufferedimage=ImageIO.read(newfile);
            int width = bufferedimage.getWidth();
            int height = bufferedimage.getHeight();
            if (width > 52) {
                bufferedimage=cropImage(bufferedimage,(int) ((width - 52) / 2),0,(int) (width - (width-52) / 2),(int) (height));
                if (height > 16) {
                    bufferedimage=cropImage(bufferedimage,0,(int) ((height - 16) / 2),52,(int) (height - (height - 16) / 2));
                }
            }else{
                if (height > 16) {
                    bufferedimage=cropImage(bufferedimage,0,(int) ((height - 16) / 2),(int) (width),(int) (height - (height - 16) / 2));
                }
            }
            ImageIO.write(bufferedimage, "jpg", new File(imgUrl));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    
    
}
