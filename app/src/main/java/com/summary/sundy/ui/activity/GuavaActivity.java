package com.summary.sundy.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.summary.common.base.BaseActivity;
import com.summary.sundy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * google guava 工具类的使用和介绍
 */
public class GuavaActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.sy_guava_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        //1集合的创建
        //普通的Collection的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String, String> map = Maps.newHashMap();
        //不变Collection的创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1");
        //创建不可变集合 先理解什么是immutable(不可变)对象
        //1.在多线程操作下，是线程安全的。
        //2.所有不可变集合会比可变集合更有效的利用资源。
        //3.中途不可改变
        ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3", "4");
        // 这句话就声明了一个不可变的list集合，里面有数据1，2，3，4。方法中的==操作集合的方法都声明过期==，并且抛出异常。
        // 没用guava之前是需要声明并且加各种包裹集合才能实现这个功能。

        //当我们需要一个map中包含key为String value为List类型的时候 以前我们是这样写的
        Map<String, List<Integer>> mapData = new HashMap<String, List<Integer>>();
        List<Integer> lists = new ArrayList<Integer>();
        lists.add(1);
        lists.add(2);
        mapData.put("aa", lists);
        System.out.println(map.get("aa"));//[1, 2]
        Log.i("log_data", "map: =" + map.get("aa"));
        //而现在
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("aa", 1);
        multimap.put("aa", 2);
        System.out.println(multimap.get("aa"));  //[1, 2]
        Log.i("log_data", "ArrayListMultimap: =" + multimap.get("aa"));
        //其他的黑科技集合
        /**
         * MultiSet: 无序+可重复   count()方法获取单词的次数  增强了可读性+操作简单
         * 创建方式:  Multiset<String> set = HashMultiset.create();
         *
         * Multimap: key-value  key可以重复
         * 创建方式: Multimap<String, String> teachers = ArrayListMultimap.create();
         *
         * BiMap: 双向Map(Bidirectional Map) 键与值都不能重复
         * 创建方式:  BiMap<String, String> biMap = HashBiMap.create();
         *
         * Table: 双键的Map Map--> Table-->rowKey+columnKey+value  //和sql中的联合主键有点像
         * 创建方式: Table<String, String, Integer> tables = HashBasedTable.create();
         *
         * ...等等(guava中还有很多java里面没有给出的集合类型)
         */
        //2.将集合转换为特定规则的字符串
        //以前我们将list转换为特定规则的字符串是这样写的:
        List<String> strList = new ArrayList<>();
        strList.add("aa");
        strList.add("bb");
        strList.add("cc");
        String str = "";
        for (int i = 0; i < strList.size(); i++) {
            str = str + "-" + strList.get(i);
        }//str 为-aa-bb-cc
        Log.i("log_data", "List数据拼接: =" + multimap.get("aa"));
        //sse guava
        List<String> strings = new ArrayList<>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        String resule = Joiner.on("-").join(strings);
        Log.i("log_data", "Guava Joiner List数据自动拼接: =" + multimap.get("aa"));
        //把map集合转换为特定规则的字符串
        Map<String, Integer> maps = Maps.newHashMap();
        maps.put("xiaoming", 12);
        maps.put("xiaohong", 13);
        String result = Joiner.on(",").withKeyValueSeparator("=").join(maps);
        // result为 xiaoming=12,xiaohong=13
        Log.i("log_data", "Guava Joiner map数据自动拼接: =" + multimap.get("aa"));

        //3.将String转换为特定的集合
        //use java
        List<String> listss = new ArrayList<String>();
        String a = "1-2-3-4-5-6";
        String[] strs = a.split("-");
        for (int i = 0; i < strs.length; i++) {
            listss.add(strs[i]);
        }
        Log.i("log_data", "java split list数据拆分: =" + listss.toArray().toString());
        //use guava
        String strss = "1-2-3-4-5-6";
        List<String> listsss = Splitter.on("-").splitToList(strss);
        //list为  [1, 2, 3, 4, 5, 6]
        Log.i("log_data", "Guava Splitter list数据拆分: =" + listsss.toArray().toString());

        //如果
        //str="1-2-3-4- 5-  6  ";
        //==使用 "-" 切分字符串并去除空串与空格== omitEmptyStrings().trimResults() 去除空串与空格
        String strDta = "1-2-3-4-  5-  6   ";
        List<String> listStrs = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(strDta);
        Log.i("log_data", "Guava Splitter list带有空格数据拆分: =" + listStrs.toArray().toString());

        //4.guava还支持多个字符切割，或者特定的正则分隔
        String input = "aa.dd,,ff,,.";
        List<String> resultStr = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(input);
        Log.i("log_data", "Guava Splitter 字符串切个: =" + resultStr.toArray().toString());

        //==关于字符串的操作 都是在Splitter这个类上进行的。==
        // 判断匹配结果
        boolean resultStatus = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).matches('K'); //true
        // 保留数字文本
        String s1 = CharMatcher.digit().retainFrom("abc 123 efg"); //123
        // 删除数字文本
        String s2 = CharMatcher.digit().removeFrom("abc 123 efg");    //abc  efg


    }
}
