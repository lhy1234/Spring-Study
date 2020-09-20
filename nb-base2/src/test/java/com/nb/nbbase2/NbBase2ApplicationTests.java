package com.nb.nbbase2;

import cn.hutool.extra.pinyin.PinyinUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@SpringBootTest
class NbBase2ApplicationTests {


    @Test
    public void testApp() {
        Apple apple = Apple.builder().build();

    }



    @Test
    public void testPinYin() {
        //重庆，厦门，长春 长沙
        String ss = PinyinUtil.getPinyin("长沙","");
        System.err.println(ss);
    }




//{"code":100,"msg":"success!","data":[{"schoolId":10,"schoolName":"重庆新东方学校","simpleSchoolName":"重庆","schoolLevel":"A"},{"schoolId":27,"schoolName":"云南新东方学校","simpleSchoolName":"云南","schoolLevel":"C"},{"schoolId":41,"schoolName":"厦门新东方学校","simpleSchoolName":"厦门","schoolLevel":"A"},{"schoolId":45,"schoolName":"南宁新东方学校","simpleSchoolName":"南宁","schoolLevel":"C"},{"schoolId":51,"schoolName":"富阳新东方学校","simpleSchoolName":"富阳","schoolLevel":"A"},{"schoolId":58,"schoolName":"十堰新东方学校","simpleSchoolName":"十堰","schoolLevel":"C"},{"schoolId":61,"schoolName":"潍坊新东方","simpleSchoolName":"潍坊","schoolLevel":"D"},{"schoolId":68,"schoolName":"保定新东方学校","simpleSchoolName":"保定","schoolLevel":"A"},{"schoolId":69,"schoolName":"重庆永川区新东方学校","simpleSchoolName":"重庆永川区","schoolLevel":"A"},{"schoolId":84,"schoolName":"金华新东方学校","simpleSchoolName":"金华","schoolLevel":"A"},{"schoolId":95,"schoolName":"廊坊新东方学校","simpleSchoolName":"廊坊","schoolLevel":"其他"},{"schoolId":99,"schoolName":"淮安新东方","simpleSchoolName":"淮安","schoolLevel":"D"},{"schoolId":101,"schoolName":"常州新东方","simpleSchoolName":"常州","schoolLevel":"D"},{"schoolId":504,"schoolName":"海口新东方","simpleSchoolName":"海口","schoolLevel":"D"},{"schoolId":506,"schoolName":"东莞新东方","simpleSchoolName":"东莞","schoolLevel":"D"},{"schoolId":518,"schoolName":"新乡新东方","simpleSchoolName":"新乡","schoolLevel":"其他"},{"schoolId":523,"schoolName":"承德新东方","simpleSchoolName":"承德","schoolLevel":"其他"},{"schoolId":3,"schoolName":"广州新东方学校","simpleSchoolName":"广州","schoolLevel":"A"},{"schoolId":8,"schoolName":"深圳新东方学校","simpleSchoolName":"深圳","schoolLevel":"B"},{"schoolId":31,"schoolName":"宜昌新东方学校","simpleSchoolName":"宜昌","schoolLevel":"A"},{"schoolId":50,"schoolName":"吉林新东方学校","simpleSchoolName":"吉林","schoolLevel":"D"},{"schoolId":56,"schoolName":"唐山新东方学校","simpleSchoolName":"唐山","schoolLevel":"C"},{"schoolId":60,"schoolName":"烟台新东方","simpleSchoolName":"烟台","schoolLevel":"C"},{"schoolId":73,"schoolName":"邯郸新东方","simpleSchoolName":"邯郸","schoolLevel":"其他"},{"schoolId":74,"schoolName":"酷学慧思","simpleSchoolName":"酷学慧思","schoolLevel":"其他"},{"schoolId":82,"schoolName":"开封新东方","simpleSchoolName":"开封","schoolLevel":"其他"},{"schoolId":98,"schoolName":"咸阳新东方学校","simpleSchoolName":"咸阳","schoolLevel":"其他"},{"schoolId":521,"schoolName":"包头新东方","simpleSchoolName":"包头","schoolLevel":"D"},{"schoolId":7,"schoolName":"南京新东方学校","simpleSchoolName":"南京","schoolLevel":"A"},{"schoolId":15,"schoolName":"哈尔滨新东方学校","simpleSchoolName":"哈尔滨","schoolLevel":"C"},{"schoolId":23,"schoolName":"苏州新东方学校","simpleSchoolName":"苏州","schoolLevel":"A"},{"schoolId":25,"schoolName":"合肥新东方学校","simpleSchoolName":"合肥","schoolLevel":"A"},{"schoolId":30,"schoolName":"佛山新东方学校","simpleSchoolName":"佛山","schoolLevel":"C"},{"schoolId":34,"schoolName":"荆州新东方学校","simpleSchoolName":"荆州","schoolLevel":"A"},{"schoolId":36,"schoolName":"大连新东方学校","simpleSchoolName":"大连","schoolLevel":"C"},{"schoolId":49,"schoolName":"镇江新东方学校","simpleSchoolName":"镇江","schoolLevel":"C"},{"schoolId":53,"schoolName":"洛阳新东方学校","simpleSchoolName":"洛阳","schoolLevel":"C"},{"schoolId":54,"schoolName":"呼和浩特新东方学校","simpleSchoolName":"呼和浩特","schoolLevel":"C"},{"schoolId":59,"schoolName":"温州新东方","simpleSchoolName":"温州","schoolLevel":"江浙"},{"schoolId":64,"schoolName":"珠海新东方","simpleSchoolName":"珠海","schoolLevel":"D"},{"schoolId":65,"schoolName":"新东方教育培训中心","simpleSchoolName":"","schoolLevel":"其他"},{"schoolId":85,"schoolName":"义乌新东方学校","simpleSchoolName":"义乌","schoolLevel":"A"},{"schoolId":86,"schoolName":"盐城新东方学校","simpleSchoolName":"盐城","schoolLevel":"D"},{"schoolId":88,"schoolName":"东方和力","simpleSchoolName":"东方和力","schoolLevel":"其他"},{"schoolId":93,"schoolName":"杭州斯迪姆新东方","simpleSchoolName":"杭州斯迪姆","schoolLevel":"其他"},{"schoolId":96,"schoolName":"嘉兴新东方学校","simpleSchoolName":"嘉兴","schoolLevel":"江浙"},{"schoolId":97,"schoolName":"台州新东方学校","simpleSchoolName":"台州","schoolLevel":"江浙"},{"schoolId":100,"schoolName":"泰州新东方","simpleSchoolName":"泰州","schoolLevel":"D"},{"schoolId":516,"schoolName":"德清新东方","simpleSchoolName":"德清","schoolLevel":"江浙"},{"schoolId":522,"schoolName":"西宁新东方","simpleSchoolName":"西宁","schoolLevel":"D"},{"schoolId":525,"schoolName":"鹤壁新东方","simpleSchoolName":"鹤壁","schoolLevel":"其他"},{"schoolId":527,"schoolName":"驻马店新东方","simpleSchoolName":"驻马店","schoolLevel":"其他"},{"schoolId":1,"schoolName":"北京新东方学校","simpleSchoolName":"北京","schoolLevel":"A"},{"schoolId":11,"schoolName":"成都新东方学校","simpleSchoolName":"成都","schoolLevel":"B"},{"schoolId":14,"schoolName":"襄阳新东方学校","simpleSchoolName":"襄阳","schoolLevel":"C"},{"schoolId":32,"schoolName":"无锡新东方学校","simpleSchoolName":"无锡","schoolLevel":"B"},{"schoolId":38,"schoolName":"宁波新东方学校","simpleSchoolName":"宁波","schoolLevel":"江浙"},{"schoolId":46,"schoolName":"徐州新东方学校","simpleSchoolName":"徐州","schoolLevel":"C"},{"schoolId":48,"schoolName":"湘潭新东方学校","simpleSchoolName":"湘潭","schoolLevel":"B"},{"schoolId":89,"schoolName":"斯林姆国际教育","simpleSchoolName":"斯林姆国际教育","schoolLevel":"其他"},{"schoolId":102,"schoolName":"斯林姆南京启橙新东方","simpleSchoolName":"斯林姆南京启橙","schoolLevel":"其他"},{"schoolId":501,"schoolName":"焦作新东方","simpleSchoolName":"焦作","schoolLevel":"C"},{"schoolId":502,"schoolName":"绍兴新东方","simpleSchoolName":"绍兴","schoolLevel":"江浙"},{"schoolId":503,"schoolName":"湖州新东方","simpleSchoolName":"湖州","schoolLevel":"江浙"},{"schoolId":528,"schoolName":"三门峡新东方","simpleSchoolName":"三门峡","schoolLevel":"其他"},{"schoolId":529,"schoolName":"信阳新东方","simpleSchoolName":"信阳","schoolLevel":"其他"},{"schoolId":531,"schoolName":"商丘新东方培训学校有限公司","simpleSchoolName":"商丘","schoolLevel":"其他"},{"schoolId":9,"schoolName":"沈阳新东方学校","simpleSchoolName":"沈阳","schoolLevel":"C"},{"schoolId":16,"schoolName":"长沙新东方学校","simpleSchoolName":"长沙","schoolLevel":"B"},{"schoolId":24,"schoolName":"石家庄新东方学校","simpleSchoolName":"石家庄","schoolLevel":"C"},{"schoolId":26,"schoolName":"福州新东方学校","simpleSchoolName":"福州","schoolLevel":"B"},{"schoolId":29,"schoolName":"株洲新东方学校","simpleSchoolName":"株洲","schoolLevel":"其他"},{"schoolId":44,"schoolName":"青岛市市南区新东方教育培训学校有限公司","simpleSchoolName":"青岛","schoolLevel":"B"},{"schoolId":55,"schoolName":"乌鲁木齐新东方学校","simpleSchoolName":"乌鲁木齐","schoolLevel":"B"},{"schoolId":57,"schoolName":"贵阳新东方学校","simpleSchoolName":"贵阳","schoolLevel":"C"},{"schoolId":71,"schoolName":"锦州新东方学校","simpleSchoolName":"锦州","schoolLevel":"D"},{"schoolId":72,"schoolName":"泰安新东方学校","simpleSchoolName":"泰安","schoolLevel":"A"},{"schoolId":87,"schoolName":"连云港学校","simpleSchoolName":"连云港","schoolLevel":"D"},{"schoolId":92,"schoolName":"晋中新东方学校","simpleSchoolName":"晋中","schoolLevel":"其他"},{"schoolId":94,"schoolName":"余杭新东方学校","simpleSchoolName":"余杭","schoolLevel":"A"},{"schoolId":505,"schoolName":"银川新东方","simpleSchoolName":"银川","schoolLevel":"D"},{"schoolId":508,"schoolName":"沧州新东方","simpleSchoolName":"沧州","schoolLevel":"其他"},{"schoolId":509,"schoolName":"秦皇岛新东方","simpleSchoolName":"秦皇岛","schoolLevel":"其他"},{"schoolId":510,"schoolName":"安阳新东方","simpleSchoolName":"安阳","schoolLevel":"其他"},{"schoolId":519,"schoolName":"柳州新东方学校","simpleSchoolName":"柳州","schoolLevel":"其他"},{"schoolId":2,"schoolName":"上海新东方学校","simpleSchoolName":"上海","schoolLevel":"A"},{"schoolId":20,"schoolName":"郑州新东方学校","simpleSchoolName":"郑州","schoolLevel":"B"},{"schoolId":21,"schoolName":"太原新东方学校","simpleSchoolName":"太原","schoolLevel":"B"},{"schoolId":22,"schoolName":"济南新东方学校","simpleSchoolName":"济南","schoolLevel":"A"},{"schoolId":526,"schoolName":"邢台新东方","simpleSchoolName":"邢台","schoolLevel":"其他"},{"schoolId":4,"schoolName":"武汉新东方学校","simpleSchoolName":"武汉","schoolLevel":"A"},{"schoolId":5,"schoolName":"天津新东方学校","simpleSchoolName":"天津","schoolLevel":"B"},{"schoolId":6,"schoolName":"西安新东方学校","simpleSchoolName":"西安","schoolLevel":"A"},{"schoolId":18,"schoolName":"长春新东方学校","simpleSchoolName":"长春","schoolLevel":"B"},{"schoolId":19,"schoolName":"杭州新东方学校","simpleSchoolName":"杭州","schoolLevel":"A"},{"schoolId":35,"schoolName":"南昌新东方学校","simpleSchoolName":"南昌","schoolLevel":"A"},{"schoolId":37,"schoolName":"黄石新东方学校","simpleSchoolName":"黄石","schoolLevel":"A"},{"schoolId":40,"schoolName":"兰州新东方学校","simpleSchoolName":"兰州","schoolLevel":"B"},{"schoolId":52,"schoolName":"南通新东方学校","simpleSchoolName":"南通","schoolLevel":"D"},{"schoolId":63,"schoolName":"素质教育中心(百学汇)","simpleSchoolName":"素质教育中心(百学汇)","schoolLevel":"其他"},{"schoolId":66,"schoolName":"扬州新东方","simpleSchoolName":"扬州","schoolLevel":"D"},{"schoolId":70,"schoolName":"深圳美国初高中留学中","simpleSchoolName":"深圳美国初高中留学中","schoolLevel":"其他"},{"schoolId":75,"schoolName":"优播","simpleSchoolName":"优播","schoolLevel":"其他"},{"schoolId":83,"schoolName":"南阳新东方学校","simpleSchoolName":"南阳","schoolLevel":"B"},{"schoolId":90,"schoolName":"葫芦岛新东方","simpleSchoolName":"葫芦岛","schoolLevel":"其他"},{"schoolId":507,"schoolName":"中山新东方","simpleSchoolName":"中山","schoolLevel":"D"},{"schoolId":517,"schoolName":"绵阳新东方","simpleSchoolName":"绵阳","schoolLevel":"D"},{"schoolId":520,"schoolName":"惠州新东方学校","simpleSchoolName":"惠州","schoolLevel":"D"},{"schoolId":524,"schoolName":"许昌新东方","simpleSchoolName":"许昌","schoolLevel":"其他"}]}
    @Test
    public void test(){
        RestTemplate restTemplate = new RestTemplate();
        String secret = "b9370df-d629-4ece-a45e-611a6d6a5d9c";
        String time = "2020-09-04 10:17";
        String sign = DigestUtils.md5Hex(secret+time);
        String url = "https://ucanadmin.staff.xdf.cn/br2/common/school/level/info";
        String timeUrl = "https://ucanadmin.staff.xdf.cn/br2/common/system/time";



        HttpHeaders headers = new HttpHeaders();
        //定义请求参数类型，这里用json所以是MediaType.APPLICATION_JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        //RestTemplate带参传的时候要用HttpEntity<?>对象传递
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sign", sign);
        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(map, headers);

        ResponseEntity<String> entity = restTemplate.postForEntity(url, request, String.class);
        //获取3方接口返回的数据通过entity.getBody();它返回的是一个字符串；
        String body = entity.getBody();

        System.err.println(body);


    }
    @Test
    void contextLoads() {

        Map<String,String> map= new HashMap<>();
        map.put("aaa","aaa");
        map.put("bbb","bbb");
        map.put("ccc","ccc");

        List<String> list = new ArrayList<>(map.values());

        System.out.println(list.size());
    }

    @Test
    public void testM1(){

        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        //List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.err.println("groupBy:"+groupBy);
        //{1=[Apple{id=1, name='苹果1', money=3.25, num=10}, Apple{id=1, name='苹果2', money=1.35, num=20}], 2=[Apple{id=2, name='香蕉', money=2.89, num=30}], 3=[Apple{id=3, name='荔枝', money=9.99, num=40}]}
    }

    @Test
    public void tests2(){

        List<School> list= new ArrayList<>();
        for(int i=0;i<100;i++){
            School s = new School();
            s.setSchoolId(i);
            s.setSchoolName("学校-"+i);

            if(i %  2== 0){
                s.setSchoolGrade("A");
            }else
            if(i %  3== 0){
                s.setSchoolGrade("B");
            }else
            if(i %  4== 0){
                s.setSchoolGrade("C");
            }else
            if(i %  5== 0){
                s.setSchoolGrade("D");
            }else{
                s.setSchoolGrade("E");
            }

            list.add(s);
        }

        System.err.println(list.size());

        Map<String, List<School>> groupBy = list.stream().collect(Collectors.groupingBy(School::getSchoolGrade));

        System.err.println(groupBy);
    }


    public void ttt(){
        String sss = "[{\"schoolId\":10,\"schoolName\":\"重庆新东方学校\",\"simpleSchoolName\":\"重庆\",\"schoolLevel\":\"A\"},{\"schoolId\":27,\"schoolName\":\"云南新东方学校\",\"simpleSchoolName\":\"云南\",\"schoolLevel\":\"C\"},{\"schoolId\":41,\"schoolName\":\"厦门新东方学校\",\"simpleSchoolName\":\"厦门\",\"schoolLevel\":\"A\"},{\"schoolId\":45,\"schoolName\":\"南宁新东方学校\",\"simpleSchoolName\":\"南宁\",\"schoolLevel\":\"C\"},{\"schoolId\":51,\"schoolName\":\"富阳新东方学校\",\"simpleSchoolName\":\"富阳\",\"schoolLevel\":\"A\"},{\"schoolId\":58,\"schoolName\":\"十堰新东方学校\",\"simpleSchoolName\":\"十堰\",\"schoolLevel\":\"C\"},{\"schoolId\":61,\"schoolName\":\"潍坊新东方\",\"simpleSchoolName\":\"潍坊\",\"schoolLevel\":\"D\"},{\"schoolId\":68,\"schoolName\":\"保定新东方学校\",\"simpleSchoolName\":\"保定\",\"schoolLevel\":\"A\"},{\"schoolId\":69,\"schoolName\":\"重庆永川区新东方学校\",\"simpleSchoolName\":\"重庆永川区\",\"schoolLevel\":\"A\"},{\"schoolId\":84,\"schoolName\":\"金华新东方学校\",\"simpleSchoolName\":\"金华\",\"schoolLevel\":\"A\"},{\"schoolId\":95,\"schoolName\":\"廊坊新东方学校\",\"simpleSchoolName\":\"廊坊\",\"schoolLevel\":\"其他\"},{\"schoolId\":99,\"schoolName\":\"淮安新东方\",\"simpleSchoolName\":\"淮安\",\"schoolLevel\":\"D\"},{\"schoolId\":101,\"schoolName\":\"常州新东方\",\"simpleSchoolName\":\"常州\",\"schoolLevel\":\"D\"},{\"schoolId\":504,\"schoolName\":\"海口新东方\",\"simpleSchoolName\":\"海口\",\"schoolLevel\":\"D\"},{\"schoolId\":506,\"schoolName\":\"东莞新东方\",\"simpleSchoolName\":\"东莞\",\"schoolLevel\":\"D\"},{\"schoolId\":518,\"schoolName\":\"新乡新东方\",\"simpleSchoolName\":\"新乡\",\"schoolLevel\":\"其他\"},{\"schoolId\":523,\"schoolName\":\"承德新东方\",\"simpleSchoolName\":\"承德\",\"schoolLevel\":\"其他\"},{\"schoolId\":3,\"schoolName\":\"广州新东方学校\",\"simpleSchoolName\":\"广州\",\"schoolLevel\":\"A\"},{\"schoolId\":8,\"schoolName\":\"深圳新东方学校\",\"simpleSchoolName\":\"深圳\",\"schoolLevel\":\"B\"},{\"schoolId\":31,\"schoolName\":\"宜昌新东方学校\",\"simpleSchoolName\":\"宜昌\",\"schoolLevel\":\"A\"},{\"schoolId\":50,\"schoolName\":\"吉林新东方学校\",\"simpleSchoolName\":\"吉林\",\"schoolLevel\":\"D\"},{\"schoolId\":56,\"schoolName\":\"唐山新东方学校\",\"simpleSchoolName\":\"唐山\",\"schoolLevel\":\"C\"},{\"schoolId\":60,\"schoolName\":\"烟台新东方\",\"simpleSchoolName\":\"烟台\",\"schoolLevel\":\"C\"},{\"schoolId\":73,\"schoolName\":\"邯郸新东方\",\"simpleSchoolName\":\"邯郸\",\"schoolLevel\":\"其他\"},{\"schoolId\":74,\"schoolName\":\"酷学慧思\",\"simpleSchoolName\":\"酷学慧思\",\"schoolLevel\":\"其他\"},{\"schoolId\":82,\"schoolName\":\"开封新东方\",\"simpleSchoolName\":\"开封\",\"schoolLevel\":\"其他\"},{\"schoolId\":98,\"schoolName\":\"咸阳新东方学校\",\"simpleSchoolName\":\"咸阳\",\"schoolLevel\":\"其他\"},{\"schoolId\":521,\"schoolName\":\"包头新东方\",\"simpleSchoolName\":\"包头\",\"schoolLevel\":\"D\"},{\"schoolId\":7,\"schoolName\":\"南京新东方学校\",\"simpleSchoolName\":\"南京\",\"schoolLevel\":\"A\"},{\"schoolId\":15,\"schoolName\":\"哈尔滨新东方学校\",\"simpleSchoolName\":\"哈尔滨\",\"schoolLevel\":\"C\"},{\"schoolId\":23,\"schoolName\":\"苏州新东方学校\",\"simpleSchoolName\":\"苏州\",\"schoolLevel\":\"A\"},{\"schoolId\":25,\"schoolName\":\"合肥新东方学校\",\"simpleSchoolName\":\"合肥\",\"schoolLevel\":\"A\"},{\"schoolId\":30,\"schoolName\":\"佛山新东方学校\",\"simpleSchoolName\":\"佛山\",\"schoolLevel\":\"C\"},{\"schoolId\":34,\"schoolName\":\"荆州新东方学校\",\"simpleSchoolName\":\"荆州\",\"schoolLevel\":\"A\"},{\"schoolId\":36,\"schoolName\":\"大连新东方学校\",\"simpleSchoolName\":\"大连\",\"schoolLevel\":\"C\"},{\"schoolId\":49,\"schoolName\":\"镇江新东方学校\",\"simpleSchoolName\":\"镇江\",\"schoolLevel\":\"C\"},{\"schoolId\":53,\"schoolName\":\"洛阳新东方学校\",\"simpleSchoolName\":\"洛阳\",\"schoolLevel\":\"C\"},{\"schoolId\":54,\"schoolName\":\"呼和浩特新东方学校\",\"simpleSchoolName\":\"呼和浩特\",\"schoolLevel\":\"C\"},{\"schoolId\":59,\"schoolName\":\"温州新东方\",\"simpleSchoolName\":\"温州\",\"schoolLevel\":\"江浙\"},{\"schoolId\":64,\"schoolName\":\"珠海新东方\",\"simpleSchoolName\":\"珠海\",\"schoolLevel\":\"D\"},{\"schoolId\":65,\"schoolName\":\"新东方教育培训中心\",\"simpleSchoolName\":\"\",\"schoolLevel\":\"其他\"},{\"schoolId\":85,\"schoolName\":\"义乌新东方学校\",\"simpleSchoolName\":\"义乌\",\"schoolLevel\":\"A\"},{\"schoolId\":86,\"schoolName\":\"盐城新东方学校\",\"simpleSchoolName\":\"盐城\",\"schoolLevel\":\"D\"},{\"schoolId\":88,\"schoolName\":\"东方和力\",\"simpleSchoolName\":\"东方和力\",\"schoolLevel\":\"其他\"},{\"schoolId\":93,\"schoolName\":\"杭州斯迪姆新东方\",\"simpleSchoolName\":\"杭州斯迪姆\",\"schoolLevel\":\"其他\"},{\"schoolId\":96,\"schoolName\":\"嘉兴新东方学校\",\"simpleSchoolName\":\"嘉兴\",\"schoolLevel\":\"江浙\"},{\"schoolId\":97,\"schoolName\":\"台州新东方学校\",\"simpleSchoolName\":\"台州\",\"schoolLevel\":\"江浙\"},{\"schoolId\":100,\"schoolName\":\"泰州新东方\",\"simpleSchoolName\":\"泰州\",\"schoolLevel\":\"D\"},{\"schoolId\":516,\"schoolName\":\"德清新东方\",\"simpleSchoolName\":\"德清\",\"schoolLevel\":\"江浙\"},{\"schoolId\":522,\"schoolName\":\"西宁新东方\",\"simpleSchoolName\":\"西宁\",\"schoolLevel\":\"D\"},{\"schoolId\":525,\"schoolName\":\"鹤壁新东方\",\"simpleSchoolName\":\"鹤壁\",\"schoolLevel\":\"其他\"},{\"schoolId\":527,\"schoolName\":\"驻马店新东方\",\"simpleSchoolName\":\"驻马店\",\"schoolLevel\":\"其他\"},{\"schoolId\":1,\"schoolName\":\"北京新东方学校\",\"simpleSchoolName\":\"北京\",\"schoolLevel\":\"A\"},{\"schoolId\":11,\"schoolName\":\"成都新东方学校\",\"simpleSchoolName\":\"成都\",\"schoolLevel\":\"B\"},{\"schoolId\":14,\"schoolName\":\"襄阳新东方学校\",\"simpleSchoolName\":\"襄阳\",\"schoolLevel\":\"C\"},{\"schoolId\":32,\"schoolName\":\"无锡新东方学校\",\"simpleSchoolName\":\"无锡\",\"schoolLevel\":\"B\"},{\"schoolId\":38,\"schoolName\":\"宁波新东方学校\",\"simpleSchoolName\":\"宁波\",\"schoolLevel\":\"江浙\"},{\"schoolId\":46,\"schoolName\":\"徐州新东方学校\",\"simpleSchoolName\":\"徐州\",\"schoolLevel\":\"C\"},{\"schoolId\":48,\"schoolName\":\"湘潭新东方学校\",\"simpleSchoolName\":\"湘潭\",\"schoolLevel\":\"B\"},{\"schoolId\":89,\"schoolName\":\"斯林姆国际教育\",\"simpleSchoolName\":\"斯林姆国际教育\",\"schoolLevel\":\"其他\"},{\"schoolId\":102,\"schoolName\":\"斯林姆南京启橙新东方\",\"simpleSchoolName\":\"斯林姆南京启橙\",\"schoolLevel\":\"其他\"},{\"schoolId\":501,\"schoolName\":\"焦作新东方\",\"simpleSchoolName\":\"焦作\",\"schoolLevel\":\"C\"},{\"schoolId\":502,\"schoolName\":\"绍兴新东方\",\"simpleSchoolName\":\"绍兴\",\"schoolLevel\":\"江浙\"},{\"schoolId\":503,\"schoolName\":\"湖州新东方\",\"simpleSchoolName\":\"湖州\",\"schoolLevel\":\"江浙\"},{\"schoolId\":528,\"schoolName\":\"三门峡新东方\",\"simpleSchoolName\":\"三门峡\",\"schoolLevel\":\"其他\"},{\"schoolId\":529,\"schoolName\":\"信阳新东方\",\"simpleSchoolName\":\"信阳\",\"schoolLevel\":\"其他\"},{\"schoolId\":531,\"schoolName\":\"商丘新东方培训学校有限公司\",\"simpleSchoolName\":\"商丘\",\"schoolLevel\":\"其他\"},{\"schoolId\":9,\"schoolName\":\"沈阳新东方学校\",\"simpleSchoolName\":\"沈阳\",\"schoolLevel\":\"C\"},{\"schoolId\":16,\"schoolName\":\"长沙新东方学校\",\"simpleSchoolName\":\"长沙\",\"schoolLevel\":\"B\"},{\"schoolId\":24,\"schoolName\":\"石家庄新东方学校\",\"simpleSchoolName\":\"石家庄\",\"schoolLevel\":\"C\"},{\"schoolId\":26,\"schoolName\":\"福州新东方学校\",\"simpleSchoolName\":\"福州\",\"schoolLevel\":\"B\"},{\"schoolId\":29,\"schoolName\":\"株洲新东方学校\",\"simpleSchoolName\":\"株洲\",\"schoolLevel\":\"其他\"},{\"schoolId\":44,\"schoolName\":\"青岛市市南区新东方教育培训学校有限公司\",\"simpleSchoolName\":\"青岛\",\"schoolLevel\":\"B\"},{\"schoolId\":55,\"schoolName\":\"乌鲁木齐新东方学校\",\"simpleSchoolName\":\"乌鲁木齐\",\"schoolLevel\":\"B\"},{\"schoolId\":57,\"schoolName\":\"贵阳新东方学校\",\"simpleSchoolName\":\"贵阳\",\"schoolLevel\":\"C\"},{\"schoolId\":71,\"schoolName\":\"锦州新东方学校\",\"simpleSchoolName\":\"锦州\",\"schoolLevel\":\"D\"},{\"schoolId\":72,\"schoolName\":\"泰安新东方学校\",\"simpleSchoolName\":\"泰安\",\"schoolLevel\":\"A\"},{\"schoolId\":87,\"schoolName\":\"连云港学校\",\"simpleSchoolName\":\"连云港\",\"schoolLevel\":\"D\"},{\"schoolId\":92,\"schoolName\":\"晋中新东方学校\",\"simpleSchoolName\":\"晋中\",\"schoolLevel\":\"其他\"},{\"schoolId\":94,\"schoolName\":\"余杭新东方学校\",\"simpleSchoolName\":\"余杭\",\"schoolLevel\":\"A\"},{\"schoolId\":505,\"schoolName\":\"银川新东方\",\"simpleSchoolName\":\"银川\",\"schoolLevel\":\"D\"},{\"schoolId\":508,\"schoolName\":\"沧州新东方\",\"simpleSchoolName\":\"沧州\",\"schoolLevel\":\"其他\"},{\"schoolId\":509,\"schoolName\":\"秦皇岛新东方\",\"simpleSchoolName\":\"秦皇岛\",\"schoolLevel\":\"其他\"},{\"schoolId\":510,\"schoolName\":\"安阳新东方\",\"simpleSchoolName\":\"安阳\",\"schoolLevel\":\"其他\"},{\"schoolId\":519,\"schoolName\":\"柳州新东方学校\",\"simpleSchoolName\":\"柳州\",\"schoolLevel\":\"其他\"},{\"schoolId\":2,\"schoolName\":\"上海新东方学校\",\"simpleSchoolName\":\"上海\",\"schoolLevel\":\"A\"},{\"schoolId\":20,\"schoolName\":\"郑州新东方学校\",\"simpleSchoolName\":\"郑州\",\"schoolLevel\":\"B\"},{\"schoolId\":21,\"schoolName\":\"太原新东方学校\",\"simpleSchoolName\":\"太原\",\"schoolLevel\":\"B\"},{\"schoolId\":22,\"schoolName\":\"济南新东方学校\",\"simpleSchoolName\":\"济南\",\"schoolLevel\":\"A\"},{\"schoolId\":526,\"schoolName\":\"邢台新东方\",\"simpleSchoolName\":\"邢台\",\"schoolLevel\":\"其他\"},{\"schoolId\":4,\"schoolName\":\"武汉新东方学校\",\"simpleSchoolName\":\"武汉\",\"schoolLevel\":\"A\"},{\"schoolId\":5,\"schoolName\":\"天津新东方学校\",\"simpleSchoolName\":\"天津\",\"schoolLevel\":\"B\"},{\"schoolId\":6,\"schoolName\":\"西安新东方学校\",\"simpleSchoolName\":\"西安\",\"schoolLevel\":\"A\"},{\"schoolId\":18,\"schoolName\":\"长春新东方学校\",\"simpleSchoolName\":\"长春\",\"schoolLevel\":\"B\"},{\"schoolId\":19,\"schoolName\":\"杭州新东方学校\",\"simpleSchoolName\":\"杭州\",\"schoolLevel\":\"A\"},{\"schoolId\":35,\"schoolName\":\"南昌新东方学校\",\"simpleSchoolName\":\"南昌\",\"schoolLevel\":\"A\"},{\"schoolId\":37,\"schoolName\":\"黄石新东方学校\",\"simpleSchoolName\":\"黄石\",\"schoolLevel\":\"A\"},{\"schoolId\":40,\"schoolName\":\"兰州新东方学校\",\"simpleSchoolName\":\"兰州\",\"schoolLevel\":\"B\"},{\"schoolId\":52,\"schoolName\":\"南通新东方学校\",\"simpleSchoolName\":\"南通\",\"schoolLevel\":\"D\"},{\"schoolId\":63,\"schoolName\":\"素质教育中心(百学汇)\",\"simpleSchoolName\":\"素质教育中心(百学汇)\",\"schoolLevel\":\"其他\"},{\"schoolId\":66,\"schoolName\":\"扬州新东方\",\"simpleSchoolName\":\"扬州\",\"schoolLevel\":\"D\"},{\"schoolId\":70,\"schoolName\":\"深圳美国初高中留学中\",\"simpleSchoolName\":\"深圳美国初高中留学中\",\"schoolLevel\":\"其他\"},{\"schoolId\":75,\"schoolName\":\"优播\",\"simpleSchoolName\":\"优播\",\"schoolLevel\":\"其他\"},{\"schoolId\":83,\"schoolName\":\"南阳新东方学校\",\"simpleSchoolName\":\"南阳\",\"schoolLevel\":\"B\"},{\"schoolId\":90,\"schoolName\":\"葫芦岛新东方\",\"simpleSchoolName\":\"葫芦岛\",\"schoolLevel\":\"其他\"},{\"schoolId\":507,\"schoolName\":\"中山新东方\",\"simpleSchoolName\":\"中山\",\"schoolLevel\":\"D\"},{\"schoolId\":517,\"schoolName\":\"绵阳新东方\",\"simpleSchoolName\":\"绵阳\",\"schoolLevel\":\"D\"},{\"schoolId\":520,\"schoolName\":\"惠州新东方学校\",\"simpleSchoolName\":\"惠州\",\"schoolLevel\":\"D\"},{\"schoolId\":524,\"schoolName\":\"许昌新东方\",\"simpleSchoolName\":\"许昌\",\"schoolLevel\":\"其他\"}]";
    }

}
