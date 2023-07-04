package day0630;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest2 {
    public static void main(String[] args) {
        String s = "<html lang=\"zh-CN\" class=\"gray\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <title>哔哩哔哩 (゜-゜)つロ 干杯~-bilibili</title>\n" +
                "    <script src=\"//s1.hdslb.com/bfs/static/laputa-home/client/assets/svgfont.36f48e78.js\" async></script><script src=\"https://s1.hdslb.com/bfs/seed/jinkela/short/b-mirror/biliMirror.umd.mini.js\"></script>\n" +
                "    <script>\n" +
                "      if (window.__INITIAL_MIRROR__) {\n" +
                "        const config = {\n" +
                "          origin: 'main',\n" +
                "          module: 'home-page',\n" +
                "          spmId: '333.1007',\n" +
                "          config: {\n" +
                "            whiteScreen: {\n" +
                "              maxLoop: 5,\n" +
                "              elemArry: ['#i_cecream'],\n" +
                "              callback: status => {\n" +
                "                console.log('白屏检测是否正常', status)\n" +
                "              },\n" +
                "              isSkeleton: false\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "        window.__INITIAL_MIRROR__(config)\n" +
                "      }\n" +
                "    </script>\n" +
                "    <meta\n" +
                "      name=\"description\"\n" +
                "      content=\"哔哩哔哩（bilibili.com)是国内知名的视频弹幕网站，这里有及时的动漫新番，活跃的ACG氛围，有创意的Up主。大家可以在这里找到许多欢乐。\"\n" +
                "    />\n" +
                "    <meta\n" +
                "      name=\"keywords\"\n" +
                "      content=\"Bilibili,哔哩哔哩,哔哩哔哩动画,哔哩哔哩弹幕网,弹幕视频,B站,弹幕,字幕,AMV,MAD,MTV,ANIME,动漫,动漫音乐,游戏,游戏解说,二次元,游戏视频,ACG,galgame,动画,番组,新番,初音,洛天依,vocaloid,日本动漫,国产动漫,手机游戏,网络游戏,电子竞技,ACG燃曲,ACG神曲,追新番,新番动漫,新番吐槽,巡音,镜音双子,千本樱,初音MIKU,舞蹈MMD,MIKUMIKUDANCE,洛天依原创曲,洛天依翻唱曲,洛天依投食歌,洛天依MMD,vocaloid家族,OST,BGM,动漫歌曲,日本动漫音乐,宫崎骏动漫音乐,动漫音乐推荐,燃系mad,治愈系mad,MAD MOVIE,MAD高燃\"\n" +
                "    />\n" +
                "    <meta name=\"renderer\" content=\"webkit\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"spm_prefix\" content=\"333.1007\" />\n" +
                "    <meta name=\"referrer\" content=\"no-referrer-when-downgrade\" />\n" +
                "    <meta name=\"applicable-device\" content=\"pc\">\n" +
                "    <meta http-equiv=\"Cache-Control\" content=\"no-transform\" />\n" +
                "    <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n" +
                "    <meta name=\"server_render\" content=\"is_server_render\" />\n" +
                "\n" +
                "    <link rel=\"dns-prefetch\" href=\"//s1.hdslb.com\" />\n" +
                "    <link rel=\"apple-touch-icon\" href=\"//static.hdslb.com/mobile/img/512.png\" />\n" +
                "    <link rel=\"shortcut icon\" href=\"https://www.bilibili.com/favicon.ico?v=1\" />\n" +
                "    <link rel=\"canonical\" href=\"https://www.bilibili.com/\" />\n" +
                "    <link rel=\"alternate\" media=\"only screen and (max-width: 640px)\" href=\"https://m.bilibili.com\" />\n" +
                "    <link\n" +
                "      rel=\"stylesheet\"\n" +
                "      href=\"//s1.hdslb.com/bfs/static/jinkela/long/font/medium.css\"\n" +
                "      media=\"print\"\n" +
                "      onload=\"this.media='all'\"\n" +
                "    />\n" +
                "    <link\n" +
                "      rel=\"stylesheet\"\n" +
                "      href=\"//s1.hdslb.com/bfs/static/jinkela/long/font/regular.css\"\n" +
                "      media=\"print\"\n" +
                "      onload=\"this.media='all'\"\n" +
                "    />\n" +
                "    <script src=\"https://www.bilibili.com/gentleman/polyfill.js?features=es2015%2Ces2016%2Ces2017%2Ces2018%2Ces2019%2Ces2020%2Ces2021%2Ces2022%2CglobalThis&flags=gated\"></script>\n" +
                "    \n" +
                "  <link rel=\"stylesheet\" href=\"//s1.hdslb.com/bfs/static/jinkela/long/laputa-css/map.css\"/>\n" +
                "  <link rel=\"stylesheet\" href=\"//s1.hdslb.com/bfs/static/jinkela/long/laputa-css/light_u.css\"/>\n" +
                "  <link id=\"__css-map__\" rel=\"stylesheet\" href=\"//s1.hdslb.com/bfs/static/jinkela/long/laputa-css/light.css\"/>";
        Pattern pattern = Pattern.compile("https:.*\\.com");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            String s1 = s.substring(matcher.start(), matcher.end());
            System.out.println(s1);
        }
    }
}
