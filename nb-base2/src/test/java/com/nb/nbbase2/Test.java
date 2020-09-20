package com.nb.nbbase2;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by lihaoyang on 2020/9/7
 */
public class Test {


    @org.junit.Test
    public void test1(){

        String ss = "[\n" +
                "            {\n" +
                "                \"schoolGrade\": \"其他\",\n" +
                "                \"schoolList\": [\n" +
                "                    {\n" +
                "                        \"schoolId\": 510,\n" +
                "                        \"schoolName\": \"安阳\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 508,\n" +
                "                        \"schoolName\": \"沧州\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 523,\n" +
                "                        \"schoolName\": \"承德\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 73,\n" +
                "                        \"schoolName\": \"邯郸\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 525,\n" +
                "                        \"schoolName\": \"鹤壁\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 90,\n" +
                "                        \"schoolName\": \"葫芦岛\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 92,\n" +
                "                        \"schoolName\": \"晋中\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 82,\n" +
                "                        \"schoolName\": \"开封\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 95,\n" +
                "                        \"schoolName\": \"廊坊\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 519,\n" +
                "                        \"schoolName\": \"柳州\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 509,\n" +
                "                        \"schoolName\": \"秦皇岛\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 528,\n" +
                "                        \"schoolName\": \"三门峡\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 98,\n" +
                "                        \"schoolName\": \"咸阳\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 526,\n" +
                "                        \"schoolName\": \"邢台\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 518,\n" +
                "                        \"schoolName\": \"新乡\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 529,\n" +
                "                        \"schoolName\": \"信阳\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 524,\n" +
                "                        \"schoolName\": \"许昌\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 527,\n" +
                "                        \"schoolName\": \"驻马店\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 29,\n" +
                "                        \"schoolName\": \"株洲\",\n" +
                "                        \"schoolGrade\": \"其他\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"schoolGrade\": \"A\",\n" +
                "                \"schoolList\": [\n" +
                "                    {\n" +
                "                        \"schoolId\": 68,\n" +
                "                        \"schoolName\": \"保定\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 1,\n" +
                "                        \"schoolName\": \"北京\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 10,\n" +
                "                        \"schoolName\": \"重庆\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 69,\n" +
                "                        \"schoolName\": \"重庆永川区\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 51,\n" +
                "                        \"schoolName\": \"富阳\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 3,\n" +
                "                        \"schoolName\": \"广州\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 19,\n" +
                "                        \"schoolName\": \"杭州\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 25,\n" +
                "                        \"schoolName\": \"合肥\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 37,\n" +
                "                        \"schoolName\": \"黄石\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 22,\n" +
                "                        \"schoolName\": \"济南\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 34,\n" +
                "                        \"schoolName\": \"荆州\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 84,\n" +
                "                        \"schoolName\": \"金华\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 35,\n" +
                "                        \"schoolName\": \"南昌\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 7,\n" +
                "                        \"schoolName\": \"南京\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 2,\n" +
                "                        \"schoolName\": \"上海\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 23,\n" +
                "                        \"schoolName\": \"苏州\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 72,\n" +
                "                        \"schoolName\": \"泰安\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 4,\n" +
                "                        \"schoolName\": \"武汉\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 41,\n" +
                "                        \"schoolName\": \"厦门\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 6,\n" +
                "                        \"schoolName\": \"西安\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 31,\n" +
                "                        \"schoolName\": \"宜昌\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 85,\n" +
                "                        \"schoolName\": \"义乌\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 94,\n" +
                "                        \"schoolName\": \"余杭\",\n" +
                "                        \"schoolGrade\": \"A\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"schoolGrade\": \"D\",\n" +
                "                \"schoolList\": [\n" +
                "                    {\n" +
                "                        \"schoolId\": 521,\n" +
                "                        \"schoolName\": \"包头\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 101,\n" +
                "                        \"schoolName\": \"常州\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 506,\n" +
                "                        \"schoolName\": \"东莞\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 504,\n" +
                "                        \"schoolName\": \"海口\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 99,\n" +
                "                        \"schoolName\": \"淮安\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 520,\n" +
                "                        \"schoolName\": \"惠州\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 50,\n" +
                "                        \"schoolName\": \"吉林\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 71,\n" +
                "                        \"schoolName\": \"锦州\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 87,\n" +
                "                        \"schoolName\": \"连云港\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 517,\n" +
                "                        \"schoolName\": \"绵阳\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 52,\n" +
                "                        \"schoolName\": \"南通\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 100,\n" +
                "                        \"schoolName\": \"泰州\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 61,\n" +
                "                        \"schoolName\": \"潍坊\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 522,\n" +
                "                        \"schoolName\": \"西宁\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 86,\n" +
                "                        \"schoolName\": \"盐城\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 66,\n" +
                "                        \"schoolName\": \"扬州\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 505,\n" +
                "                        \"schoolName\": \"银川\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 507,\n" +
                "                        \"schoolName\": \"中山\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 64,\n" +
                "                        \"schoolName\": \"珠海\",\n" +
                "                        \"schoolGrade\": \"D\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"schoolGrade\": \"B\",\n" +
                "                \"schoolList\": [\n" +
                "                    {\n" +
                "                        \"schoolId\": 18,\n" +
                "                        \"schoolName\": \"长春\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 16,\n" +
                "                        \"schoolName\": \"长沙\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 11,\n" +
                "                        \"schoolName\": \"成都\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 26,\n" +
                "                        \"schoolName\": \"福州\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 40,\n" +
                "                        \"schoolName\": \"兰州\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 83,\n" +
                "                        \"schoolName\": \"南阳\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 44,\n" +
                "                        \"schoolName\": \"青岛\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 8,\n" +
                "                        \"schoolName\": \"深圳\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 21,\n" +
                "                        \"schoolName\": \"太原\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 5,\n" +
                "                        \"schoolName\": \"天津\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 55,\n" +
                "                        \"schoolName\": \"乌鲁木齐\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 32,\n" +
                "                        \"schoolName\": \"无锡\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 48,\n" +
                "                        \"schoolName\": \"湘潭\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 20,\n" +
                "                        \"schoolName\": \"郑州\",\n" +
                "                        \"schoolGrade\": \"B\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"schoolGrade\": \"C\",\n" +
                "                \"schoolList\": [\n" +
                "                    {\n" +
                "                        \"schoolId\": 36,\n" +
                "                        \"schoolName\": \"大连\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 30,\n" +
                "                        \"schoolName\": \"佛山\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 57,\n" +
                "                        \"schoolName\": \"贵阳\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 15,\n" +
                "                        \"schoolName\": \"哈尔滨\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 54,\n" +
                "                        \"schoolName\": \"呼和浩特\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 501,\n" +
                "                        \"schoolName\": \"焦作\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 53,\n" +
                "                        \"schoolName\": \"洛阳\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 45,\n" +
                "                        \"schoolName\": \"南宁\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 9,\n" +
                "                        \"schoolName\": \"沈阳\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 24,\n" +
                "                        \"schoolName\": \"石家庄\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 58,\n" +
                "                        \"schoolName\": \"十堰\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 56,\n" +
                "                        \"schoolName\": \"唐山\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 14,\n" +
                "                        \"schoolName\": \"襄阳\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 46,\n" +
                "                        \"schoolName\": \"徐州\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 60,\n" +
                "                        \"schoolName\": \"烟台\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 27,\n" +
                "                        \"schoolName\": \"云南\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 49,\n" +
                "                        \"schoolName\": \"镇江\",\n" +
                "                        \"schoolGrade\": \"C\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"schoolGrade\": \"江浙\",\n" +
                "                \"schoolList\": [\n" +
                "                    {\n" +
                "                        \"schoolId\": 516,\n" +
                "                        \"schoolName\": \"德清\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 503,\n" +
                "                        \"schoolName\": \"湖州\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 96,\n" +
                "                        \"schoolName\": \"嘉兴\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 38,\n" +
                "                        \"schoolName\": \"宁波\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 502,\n" +
                "                        \"schoolName\": \"绍兴\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 97,\n" +
                "                        \"schoolName\": \"台州\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"schoolId\": 59,\n" +
                "                        \"schoolName\": \"温州\",\n" +
                "                        \"schoolGrade\": \"江浙\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]";

        List<GradeSchool> list = JSONObject.parseArray(ss,GradeSchool.class);

        System.err.println(list.size());

        List<GradeSchool> sortedCivilStudents = list.stream()
                .sorted(Comparator.comparing(s -> PinyinUtil.getPinyin(s.getSchoolGrade(), "")))
                .collect(Collectors.toList());

        System.err.println(JSONObject.toJSONString(sortedCivilStudents));



//
//        String s1 = PinyinUtil.getPinyin("其他","");
//        String s2 = PinyinUtil.getPinyin("江浙","");
//
//        int k = s1.compareTo(s2);
//        System.err.println(k);


    }




}
