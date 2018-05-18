package ydys.jinou.com.model.http;

/**
 * author: 晨光光
 * date : 2018/5/16 23:04
 */
public interface ServiceUrl {
    String baseUrl = "http://api.svipmovie.com/";
    //精品
    String homeUrl = "front/homePageApi/homePage.do";
    //视频详情
    String message_url="front/videoDetailApi/videoDetail.do";
    String specialUrl="front/columns/getVideoList.do";
}
