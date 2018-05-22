package ydys.jinou.com.model.http;

/**
 * author: 晨光光
 * date : 2018/5/16 23:04
 *
 *
 * http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e539330016&pnum=7
 */
public interface ServiceUrl {
    // base
    String baseUrl = "http://api.svipmovie.com/";
    // gkUrl
    String gkBoonUrl = "http://gank.io/api/data/福利/10/";
    String homeUrl = "front/homePageApi/homePage.do";
    //专题
    String specialUrl="front/columns/getVideoList.do";
    //视频详情
    String message_url="front/videoDetailApi/videoDetail.do";

}
