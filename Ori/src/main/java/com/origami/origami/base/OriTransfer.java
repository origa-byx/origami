package com.origami.origami.base;

import android.util.Log;

import androidx.annotation.IntRange;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @by: origami
 * @date: {2021-05-25}
 * @info:
 **/
public class OriTransfer {

    private final static String TAG = "OriTransfer";

    public final static int Simple = 0;
    public final static int Repeat = 1;


    private final static Map<String, Transfer> transferMap = new LinkedHashMap<>();

    public static void registerTransfer(String tag, Transfer transfer){
        transferMap.put(tag, transfer);
    }

    public static  <V> V getTransferValue(String tag){
        Transfer transfer = transferMap.get(tag);
        if(transfer == null){ Log.e(TAG,"you must register at first"); return null; }
        if(transfer.type == Simple){
            transferMap.remove(tag);
        }
        return (V) transfer.getT();
    }

    public static void removeTransfer(String tag){
        transferMap.remove(tag);
    }

    public static abstract class Transfer<T>{

        int type;

        /**
         * @param type {@link OriTransfer#Repeat} {@link OriTransfer#Simple}
         */
        public Transfer(int type) {
            this.type = type;
        }

        public abstract T getT();
    }

}
