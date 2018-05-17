package ydys.jinou.com.model.bean;

import java.util.List;

public class HomeBean {

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        private List<HotSearchListBean> hotSearchList;
        private List<ListBean> list;

        public List<HotSearchListBean> getHotSearchList() {
            return hotSearchList;
        }

        public void setHotSearchList(List<HotSearchListBean> hotSearchList) {
            this.hotSearchList = hotSearchList;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class HotSearchListBean {
            /**
             * refCounter : 1
             * cnname : xingjichuanyue
             * siteId : 1
             * simplename : xjcy
             * id : ff8080815a5f91db015a68a763b750d5
             * tagName : 星际穿越
             * createdtime : 2017-02-23 09:48:04
             * enname :
             */

            private int refCounter;
            private String cnname;
            private String siteId;
            private String simplename;
            private String id;
            private String tagName;
            private String createdtime;
            private String enname;

            public int getRefCounter() {
                return refCounter;
            }

            public void setRefCounter(int refCounter) {
                this.refCounter = refCounter;
            }

            public String getCnname() {
                return cnname;
            }

            public void setCnname(String cnname) {
                this.cnname = cnname;
            }

            public String getSiteId() {
                return siteId;
            }

            public void setSiteId(String siteId) {
                this.siteId = siteId;
            }

            public String getSimplename() {
                return simplename;
            }

            public void setSimplename(String simplename) {
                this.simplename = simplename;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public String getCreatedtime() {
                return createdtime;
            }

            public void setCreatedtime(String createdtime) {
                this.createdtime = createdtime;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }
        }

        public static class ListBean {
            /**
             * showStyle :
             * loadType : videoList
             * changeOpenFlag : false
             * line : 1
             * showType : banner
             * childList : [{"airTime":0,"duration":"","loadType":"html","score":0,"angleIcon":"","dataId":"","description":"","loadURL":"http://www.iqiyi.com/v_19rrcqwxhg.html","shareURL":"","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2018/05/10/1525915422891046470.jpg","title":"中华英雄血战金三角","roomId":""},{"airTime":2014,"duration":"02:24:28","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"61f14922f4434773961e13cee6b6ccc7","description":"　被吵醒的史矛革大闹长湖镇，最终为人类巴德（卢克·伊万斯 Luke Evans 饰）射杀。索林·橡木盾（理查德·阿米蒂奇 Richard Armitage 饰）多年的夙愿终于实现，孤山埃尔波尔重新回到矮人手中。然而这位矮人王子仿佛被史矛革的贪婪和堆成山的黄金迷惑了心窍，他 疯狂地搜寻象征王位的阿肯宝石，不仅撕毁了付给长湖镇报酬的约定，更拒绝了精灵王（李·佩斯 Lee Pace 饰）索要本族国宝的要求，为此导致三族的战争一触即发。与此同时，苍白半兽人阿索格率领大军浩浩荡荡向孤山逼近。得知消息的灰袍巫师甘道夫（伊恩·麦凯伦 Ian McKellen 饰）从中调停斡旋，而被索林视为唯一朋友的霍比特人比尔博·巴金斯（马丁·弗里曼 Martin John C. Freeman 饰）则掌握着中土命运的关键。五军会战，爆发在即！ \r\n　　本片根据J.R.R·托尔金的同名原著改编，为霍比特人系列的最后一部。","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=61f14922f4434773961e13cee6b6ccc7","shareURL":"http://m.svipmovie.com/#/moviedetails/61f14922f4434773961e13cee6b6ccc7","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/20/1500546405463031004.jpg","title":"五军之战浩瀚开启","roomId":""},{"airTime":0,"duration":"","loadType":"html","score":0,"angleIcon":"","dataId":"","description":"","loadURL":"http://engine.tuicoco.com/index/activity?appKey=4CKHyAHjESjaUQVJv8kvQnZg7WdV&adslotId=180720","shareURL":"","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2018/05/03/1525310502012085973.png","title":"初夏福利免费抢！","roomId":""},{"airTime":2010,"duration":"01:49:49","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"70cddbf9d84b4c72bd4311952f03b6d4","description":"本片根据育碧软件公司2003年的同名电子游戏改编。十五年前，孤儿达斯坦（杰克·吉伦哈尔 Jake Gyllenhaal 饰）在市集上因英勇好战被波斯国王收养入宫。十五年后，长大成人的达斯坦随两位哥哥和叔父（本·金斯利 Ben Kingsley 饰）出征，奇袭圣城阿拉姆特，并得到国王许婚，将阿拉姆特公主塔米娜（杰玛·阿特登Gemma Arterton 饰）许配与他。达斯坦无意中得到了塔米娜公主竭尽全力保护的\u201c时之砂\u201d匕首，却被诬陷毒害老国王，被迫逃亡。为了洗清罪名，同时确保伟大的波斯帝国不至于沦落他手，达斯坦胁迫塔米娜公主与他一同进入了臭名昭著的\u201c奴隶谷\u201d，破坏了阿马尔酋长（阿尔弗雷德·莫里纳 Alfred Molina 饰）的鸵鸟大赛。在老国王的葬礼上，达斯坦终于发现了幕后凶手，而塔米娜公主也终将有关\u201c时之砂\u201d的秘密据实以告\u2026\u2026","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=70cddbf9d84b4c72bd4311952f03b6d4","shareURL":"http://m.svipmovie.com/#/moviedetails/70cddbf9d84b4c72bd4311952f03b6d4","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/10/13/1507882684866007939.jpg","title":"\u201c断背男\u201d玩穿越扭转时空","roomId":""},{"airTime":2013,"duration":"02:07:44","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"a7b035f990174681ba793a5392da7328","description":"本尼迪克特·康伯巴奇饰演\u201c维基解密\u201d创始人朱利安·保罗·阿桑奇（Julian Paul Assange）。维基解密是一个大型文档泄露及分析网站，曾经在2010年公开了多达9.2万份的驻阿美军秘密文件而引起轩然大波。康伯巴奇将要饰演的朱利安·保罗·阿桑奇是网站的董事与发言人，曾主修过物理、数学，做过程序员和黑客。阿桑奇本人和网站一样都备受争议，他曾经因为解密工作获得过多项荣誉，也曾收到过国际刑警组织的逮捕令。2010年阿桑奇因涉嫌在瑞典强奸及性侵犯2名女性被通缉，2010年12月7日他向伦敦警方自首，随即被押送到威斯敏斯特地方法院出席引渡聆讯，保释申请被驳回。2012年8月16日，阿桑奇获厄瓜多尔政治庇护。","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=a7b035f990174681ba793a5392da7328","shareURL":"http://m.svipmovie.com/#/moviedetails/a7b035f990174681ba793a5392da7328","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/12/06/1512553923059060338.jpg","title":"卷福诠释传奇黑客阿桑奇","roomId":""},{"airTime":2015,"duration":"01:52:15","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"d459e58100af4e5aa6d6d09070442878","description":"未来世界，水资源短缺引发了连绵的战争。人们相互厮杀，争夺有限的资源，地球变成了血腥十足的杀戮死战场。面容恐怖的不死乔在戈壁山谷建立了难以撼动的强大武装王国，他手下的战郎驾驶装备尖端武器的战车四下抢掠，杀伐无度，甚至将自己的孩子打造成战争机器。在最近一次行动中，不死乔的得力战将弗瑞奥萨（查理兹·塞隆 Charlize Theron 饰）带着生育者们叛逃，这令不死乔恼羞成怒，发誓要追回生育者。经历了激烈的追逐战和摧毁力极强的沙尘暴，弗瑞奥萨和作为血主的麦克斯（汤姆·哈迪 Tom Hardy 饰）被迫上路，而身后不仅有不死乔的追兵，还有汽油镇、子弹农场的重兵追逐。 \r\n　　末世战争，全面爆发\u2026\u2026","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=d459e58100af4e5aa6d6d09070442878","shareURL":"http://m.svipmovie.com/#/moviedetails/d459e58100af4e5aa6d6d09070442878","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/20/1500546379995032336.jpg","title":"汤姆哈迪上演末日狂飙","roomId":""},{"airTime":2011,"duration":"01:48:20","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"6249b96031584bad9b1ff3b2b1e4240d","description":"外星人丹尼尔（亚历克斯\u2022帕蒂弗 Alex Pettyfer 饰）以及与自己有着相同命运的孩子们为了躲避侵略他们星球的茅迦人的追杀而逃到地球，几年来，丹尼尔不断的感知到自己同伴遇害，为了活命，他在自己保护者亨利的陪伴下一直过着流亡的生活。在天堂镇，丹尼尔邂逅了美丽的少女萨拉（迪安娜\u2022阿格隆 Dianna Agron 饰）并且认识了胆小懦弱却又痴迷于外星人的萨姆（卡兰\u2022麦克奥利菲 Callan McAuliffe 饰）。恐怖的茅迦人最终找到了丹尼尔的行踪，这一次，丹尼尔没有选择逃避，他决定要用自己逐渐强大的超能力战胜敌人。然而要想战胜强大的茅迦人并不容易\u2026\u2026 \r\n　　本片改编自系列漫画的第一部，由电影《变形金钢》系列的导演迈克尔\u2022贝（Michael Bay）监制。","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=6249b96031584bad9b1ff3b2b1e4240d","shareURL":"http://m.svipmovie.com/#/moviedetails/6249b96031584bad9b1ff3b2b1e4240d","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/10/13/1507882757346035958.jpg","title":"花痴外星人徒手拯救地球","roomId":""},{"airTime":2013,"duration":"01:44:45","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"3976e6cb71db457fba2bfd5448da8282","description":"电影讲述波西·杰克逊在混血人集中营平静的度过七年级后，忽然日子就变的纷乱了起来，原本和同学间的躲避球竞赛，阴错阳差的变成了一场死亡游戏，丑陋的食人族巨无霸也跟着搅和其中，波西无意中发现，他们的家园和族人正遭遇空前的灾难，必须找到\u201c金羊毛\u201d，才能拯救众人，为了解除灾难，波西奋不顾身带着伙伴们共同踏上冒险的旅程。","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=3976e6cb71db457fba2bfd5448da8282","shareURL":"http://m.svipmovie.com/#/moviedetails/3976e6cb71db457fba2bfd5448da8282","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/10/23/1508722056603044558.jpg","title":"天地众神大战一触即发","roomId":""},{"airTime":2015,"duration":"02:05:11","loadType":"video","score":0,"angleIcon":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494296614609066838.png","dataId":"5635205e57764138b0356910a1ce3a9a","description":"　资深特工伊森·亨特（汤姆·克鲁斯 Tom Cruise 饰）也有百密一疏时刻，他在接收最新任务时遭到神秘组织\u201c辛迪加\u201d的暗算落入对方手中。辛迪加是一支由全球各地前特工组成的秘密组织，此前一直被CIA视为空穴来风。在对方成员伊莎·福斯特（丽贝卡·弗格森 Rebecca Ferguson 饰）的帮助下，伊森逃出生天，并及时向威廉\u2022布莱德（杰瑞米·雷纳 Jeremy Renner 饰）汇报了辛迪加确切存在的消息。然而此时布莱德的日子并不好过，他负责的IMF机构因俄罗斯核弹头等事件遭到CIA指控并责令解散。在得知该组织密谋刺杀奥地利总统时，伊森联系上了老搭档班吉·邓恩（西蒙·佩吉 Simon Pegg 饰）展开行动，并于谜样女郎伊莎再度相会。 \r\n　　接下来的一连串事件中，辛迪加的真面目逐渐揭开，而他们也终于显露出真实的目的\u2026\u2026","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=5635205e57764138b0356910a1ce3a9a","shareURL":"http://m.svipmovie.com/#/moviedetails/5635205e57764138b0356910a1ce3a9a","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/20/1500545042468021174.jpg","title":"阿汤哥搏命徒手扒飞机","roomId":""}]
             * moreURL :
             * title : Banner
             * bigPicShowFlag :
             */

            private String showStyle;
            private String loadType;
            private String changeOpenFlag;
            private int line;
            private String showType;
            private String moreURL;
            private String title;
            private String bigPicShowFlag;
            private List<ChildListBean> childList;

            public String getShowStyle() {
                return showStyle;
            }

            public void setShowStyle(String showStyle) {
                this.showStyle = showStyle;
            }

            public String getLoadType() {
                return loadType;
            }

            public void setLoadType(String loadType) {
                this.loadType = loadType;
            }

            public String getChangeOpenFlag() {
                return changeOpenFlag;
            }

            public void setChangeOpenFlag(String changeOpenFlag) {
                this.changeOpenFlag = changeOpenFlag;
            }

            public int getLine() {
                return line;
            }

            public void setLine(int line) {
                this.line = line;
            }

            public String getShowType() {
                return showType;
            }

            public void setShowType(String showType) {
                this.showType = showType;
            }

            public String getMoreURL() {
                return moreURL;
            }

            public void setMoreURL(String moreURL) {
                this.moreURL = moreURL;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBigPicShowFlag() {
                return bigPicShowFlag;
            }

            public void setBigPicShowFlag(String bigPicShowFlag) {
                this.bigPicShowFlag = bigPicShowFlag;
            }

            public List<ChildListBean> getChildList() {
                return childList;
            }

            public void setChildList(List<ChildListBean> childList) {
                this.childList = childList;
            }

            public static class ChildListBean {
                /**
                 * airTime : 0
                 * duration :
                 * loadType : html
                 * score : 0
                 * angleIcon :
                 * dataId :
                 * description :
                 * loadURL : http://www.iqiyi.com/v_19rrcqwxhg.html
                 * shareURL :
                 * pic : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2018/05/10/1525915422891046470.jpg
                 * title : 中华英雄血战金三角
                 * roomId :
                 */

                private int airTime;
                private String duration;
                private String loadType;
                private int score;
                private String angleIcon;
                private String dataId;
                private String description;
                private String loadURL;
                private String shareURL;
                private String pic;
                private String title;
                private String roomId;

                public int getAirTime() {
                    return airTime;
                }

                public void setAirTime(int airTime) {
                    this.airTime = airTime;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getLoadType() {
                    return loadType;
                }

                public void setLoadType(String loadType) {
                    this.loadType = loadType;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public String getAngleIcon() {
                    return angleIcon;
                }

                public void setAngleIcon(String angleIcon) {
                    this.angleIcon = angleIcon;
                }

                public String getDataId() {
                    return dataId;
                }

                public void setDataId(String dataId) {
                    this.dataId = dataId;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLoadURL() {
                    return loadURL;
                }

                public void setLoadURL(String loadURL) {
                    this.loadURL = loadURL;
                }

                public String getShareURL() {
                    return shareURL;
                }

                public void setShareURL(String shareURL) {
                    this.shareURL = shareURL;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getRoomId() {
                    return roomId;
                }

                public void setRoomId(String roomId) {
                    this.roomId = roomId;
                }
            }
        }
    }
}
