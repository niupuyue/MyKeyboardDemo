package com.paulniu.mykeyboarddemo.utils;

import android.support.v4.util.ArrayMap;

import com.paulniu.mykeyboarddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Coder: niupuyue (牛谱乐)
 * Date: 2019/5/19
 * Time: 18:07
 * Desc:
 * Version:
 */
public class EmojiUtil {

    public static final int EMOJI_TYPE_CLASSICS = 0x0001;

    public static final List<Integer> emojiTypeList = new ArrayList<>();

    public static ArrayMap<String, Integer> classicsEmoji;

    static {
        emojiTypeList.add(EMOJI_TYPE_CLASSICS);
        classicsEmoji = new ArrayMap<>();
        classicsEmoji.put("[emoji00]", R.drawable.aliwx_s001);
        classicsEmoji.put("[emoji01]", R.drawable.aliwx_s002);
        classicsEmoji.put("[emoji02]", R.drawable.aliwx_s003);
        classicsEmoji.put("[emoji03]", R.drawable.aliwx_s004);
        classicsEmoji.put("[emoji04]", R.drawable.aliwx_s005);
        classicsEmoji.put("[emoji05]", R.drawable.aliwx_s006);
        classicsEmoji.put("[emoji06]", R.drawable.aliwx_s007);
        classicsEmoji.put("[emoji07]", R.drawable.aliwx_s008);
        classicsEmoji.put("[emoji08]", R.drawable.aliwx_s009);
        classicsEmoji.put("[emoji09]", R.drawable.aliwx_s010);
        classicsEmoji.put("[emoji10]", R.drawable.aliwx_s011);
        classicsEmoji.put("[emoji11]", R.drawable.aliwx_s012);
        classicsEmoji.put("[emoji12]", R.drawable.aliwx_s013);
        classicsEmoji.put("[emoji13]", R.drawable.aliwx_s014);
        classicsEmoji.put("[emoji14]", R.drawable.aliwx_s015);
        classicsEmoji.put("[emoji15]", R.drawable.aliwx_s016);
        classicsEmoji.put("[emoji16]", R.drawable.aliwx_s017);
        classicsEmoji.put("[emoji17]", R.drawable.aliwx_s018);
        classicsEmoji.put("[emoji18]", R.drawable.aliwx_s019);
        classicsEmoji.put("[emoji19]", R.drawable.aliwx_s020);
        classicsEmoji.put("[emoji20]", R.drawable.aliwx_s021);
        classicsEmoji.put("[emoji21]", R.drawable.aliwx_s022);
        classicsEmoji.put("[emoji22]", R.drawable.aliwx_s023);
        classicsEmoji.put("[emoji23]", R.drawable.aliwx_s024);
        classicsEmoji.put("[emoji24]", R.drawable.aliwx_s025);
        classicsEmoji.put("[emoji25]", R.drawable.aliwx_s026);
        classicsEmoji.put("[emoji26]", R.drawable.aliwx_s027);
        classicsEmoji.put("[emoji27]", R.drawable.aliwx_s028);
        classicsEmoji.put("[emoji28]", R.drawable.aliwx_s029);
        classicsEmoji.put("[emoji29]", R.drawable.aliwx_s030);
        classicsEmoji.put("[emoji30]", R.drawable.aliwx_s031);
        classicsEmoji.put("[emoji31]", R.drawable.aliwx_s032);
        classicsEmoji.put("[emoji32]", R.drawable.aliwx_s033);
        classicsEmoji.put("[emoji33]", R.drawable.aliwx_s034);
        classicsEmoji.put("[emoji34]", R.drawable.aliwx_s035);
        classicsEmoji.put("[emoji35]", R.drawable.aliwx_s036);
        classicsEmoji.put("[emoji36]", R.drawable.aliwx_s037);
        classicsEmoji.put("[emoji37]", R.drawable.aliwx_s038);
        classicsEmoji.put("[emoji38]", R.drawable.aliwx_s039);
        classicsEmoji.put("[emoji39]", R.drawable.aliwx_s040);
        classicsEmoji.put("[emoji40]", R.drawable.aliwx_s041);
        classicsEmoji.put("[emoji41]", R.drawable.aliwx_s042);
        classicsEmoji.put("[emoji42]", R.drawable.aliwx_s043);
        classicsEmoji.put("[emoji43]", R.drawable.aliwx_s044);
        classicsEmoji.put("[emoji44]", R.drawable.aliwx_s045);
        classicsEmoji.put("[emoji45]", R.drawable.aliwx_s046);
        classicsEmoji.put("[emoji46]", R.drawable.aliwx_s047);
        classicsEmoji.put("[emoji47]", R.drawable.aliwx_s048);
        classicsEmoji.put("[emoji48]", R.drawable.aliwx_s049);
        classicsEmoji.put("[emoji49]", R.drawable.aliwx_s050);
        classicsEmoji.put("[emoji50]", R.drawable.aliwx_s051);
        classicsEmoji.put("[emoji51]", R.drawable.aliwx_s052);
        classicsEmoji.put("[emoji52]", R.drawable.aliwx_s053);
        classicsEmoji.put("[emoji53]", R.drawable.aliwx_s054);
        classicsEmoji.put("[emoji54]", R.drawable.aliwx_s055);
        classicsEmoji.put("[emoji55]", R.drawable.aliwx_s056);
        classicsEmoji.put("[emoji56]", R.drawable.aliwx_s057);
        classicsEmoji.put("[emoji57]", R.drawable.aliwx_s058);
        classicsEmoji.put("[emoji58]", R.drawable.aliwx_s059);
        classicsEmoji.put("[emoji59]", R.drawable.aliwx_s060);
        classicsEmoji.put("[emoji60]", R.drawable.aliwx_s061);
        classicsEmoji.put("[emoji61]", R.drawable.aliwx_s062);
        classicsEmoji.put("[emoji62]", R.drawable.aliwx_s063);
        classicsEmoji.put("[emoji63]", R.drawable.aliwx_s064);
        classicsEmoji.put("[emoji64]", R.drawable.aliwx_s065);
        classicsEmoji.put("[emoji65]", R.drawable.aliwx_s066);
        classicsEmoji.put("[emoji66]", R.drawable.aliwx_s067);
        classicsEmoji.put("[emoji67]", R.drawable.aliwx_s068);
        classicsEmoji.put("[emoji68]", R.drawable.aliwx_s069);
        classicsEmoji.put("[emoji69]", R.drawable.aliwx_s070);
        classicsEmoji.put("[emoji70]", R.drawable.aliwx_s071);
        classicsEmoji.put("[emoji71]", R.drawable.aliwx_s072);
        classicsEmoji.put("[emoji72]", R.drawable.aliwx_s073);
        classicsEmoji.put("[emoji73]", R.drawable.aliwx_s074);
        classicsEmoji.put("[emoji74]", R.drawable.aliwx_s075);
        classicsEmoji.put("[emoji75]", R.drawable.aliwx_s076);
        classicsEmoji.put("[emoji76]", R.drawable.aliwx_s077);
        classicsEmoji.put("[emoji77]", R.drawable.aliwx_s078);
        classicsEmoji.put("[emoji78]", R.drawable.aliwx_s079);
        classicsEmoji.put("[emoji79]", R.drawable.aliwx_s080);
        classicsEmoji.put("[emoji80]", R.drawable.aliwx_s081);
        classicsEmoji.put("[emoji81]", R.drawable.aliwx_s082);
        classicsEmoji.put("[emoji82]", R.drawable.aliwx_s083);
        classicsEmoji.put("[emoji83]", R.drawable.aliwx_s084);
        classicsEmoji.put("[emoji84]", R.drawable.aliwx_s085);
        classicsEmoji.put("[emoji85]", R.drawable.aliwx_s086);
        classicsEmoji.put("[emoji86]", R.drawable.aliwx_s087);
        classicsEmoji.put("[emoji87]", R.drawable.aliwx_s088);
        classicsEmoji.put("[emoji88]", R.drawable.aliwx_s089);
        classicsEmoji.put("[emoji89]", R.drawable.aliwx_s090);
        classicsEmoji.put("[emoji90]", R.drawable.aliwx_s091);
        classicsEmoji.put("[emoji91]", R.drawable.aliwx_s092);
        classicsEmoji.put("[emoji92]", R.drawable.aliwx_s093);
        classicsEmoji.put("[emoji93]", R.drawable.aliwx_s094);
        classicsEmoji.put("[emoji94]", R.drawable.aliwx_s095);
        classicsEmoji.put("[emoji95]", R.drawable.aliwx_s096);
        classicsEmoji.put("[emoji96]", R.drawable.aliwx_s097);
        classicsEmoji.put("[emoji97]", R.drawable.aliwx_s098);
        classicsEmoji.put("[emoji98]", R.drawable.aliwx_s099);
        classicsEmoji.put("[emoji99]", R.drawable.aliwx_shanchu_nm);
        classicsEmoji.put("[emoji100]", null);
    }

    public static int getEmojiId(int emojiType, String emojiName) {
        Integer emojiId = null;
        switch (emojiType) {
            case EMOJI_TYPE_CLASSICS:
                emojiId = classicsEmoji.get(emojiName);
                break;
            default:
                break;
        }
        return emojiId == null ? -1 : emojiId;
    }

    public static ArrayMap<String, Integer> getEmojiMap(int emojiType) {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        switch (emojiType) {
            case EMOJI_TYPE_CLASSICS:
                arrayMap = classicsEmoji;
                break;
        }
        return arrayMap;
    }

}
