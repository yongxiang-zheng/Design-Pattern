# åä¾æ¨¡å¼ ððº
1. ä¸ºä»ä¹éè¦ä½¿ç¨åä¾æ¨¡å¼ï¼<br>
   1. å ä¸ºæä¸äºå¯¹è±¡çåå»ºåéæ¯å¼éæ¯è¾å¤§ï¼å¯ä»¥éå¤ä½¿ç¨æ¥é¿åå¼éï¼æ¯å¦æ°æ®åºé¾æ¥æ± éç¨åä¾æ¨¡å¼ï¼èçæå¼æèå³é­æ°æ®åºè¿æ¥æå¼èµ·çæçæèã
2. Javaä¸­å¦ä½å®ç°åä¾æ¨¡å¼ï¼<br>
   1. å«ç§æ¹å¼ï¼é¥¿æ±ãææ±ãDCLãéæåé¨ç±»ãæä¸¾ï¼
3. åä¾æ¨¡å¼éè¦èèçä¸ä¸ªææ ï¼
   1. æ¯å¦ä¸ºæå è½½
   2. æ¯å¦çº¿ç¨å®å¨
   3. æ¯å¦å¯ä»¥è¢«åå°ç ´è§£
## 1. é¥¿æ±å¼-éæå¸¸é
```java
package com.zyx.singleton;
// å¼éå¤§ï¼å¦æå¯¹è±¡æªè¢«ä½¿ç¨ï¼ä¹ä¼åå»º
public class Hungry {
    // ç§ææé å¨
    private Hungry(){
    }
    // åé¨åå»ºå¯¹è±¡
    private static final Hungry hungry = new Hungry();

    // æä¾å¬ç¨éææ¹æ³
    public static Hungry getHungry() {
        return hungry;
    }
    // æµè¯
    public static void main(String[] args) {
        System.out.println(Hungry.getHungry().hashCode());
        System.out.println(Hungry.getHungry().hashCode());
    }
}
```
## 2. é¥¿æ±å¼-éæä»£ç å
```java
package com.zyx.singleton;
// å¼éå¤§ï¼å¦æå¯¹è±¡æªè¢«ä½¿ç¨ï¼ä¹ä¼åå»º
public class Hungry2 {
    private static Hungry2 hungry2;

    private Hungry2(){

    }

    static {
        hungry2 = new Hungry2();
    }

    public static Hungry2 getHungry2() {
        return hungry2;
    }

    public static void main(String[] args) {
        Hungry2 hungry_01 = Hungry2.getHungry2();
        Hungry2 hungry_02 = Hungry2.getHungry2();
        System.out.println(hungry_01.hashCode());
        System.out.println(hungry_02.hashCode());
    }
}

```
## 3. ææ±å¼-01
æå è½½ãçº¿ç¨ä¸å®å¨ï¼å¤ä¸ªçº¿ç¨å¯ä»¥åæ¶è¿å¥getLazy()æ¹æ³ï¼ãå¯ä»¥è¢«åå°ç ´è§£
```java
package com.zyx.singleton;

// çº¿ç¨ä¸å®å¨ææ±å¼
public class Lazy01 {
    // ç§ææé å¨
    private Lazy01(){
    }
    // åå§åå¯¹è±¡
    private static Lazy01 lazy;
    // éæå¬å±æ¹æ³åå»ºå¯¹è±¡
    public static Lazy01 getLazy() {
        if(lazy == null){
            lazy = new Lazy01();
        }
        return lazy;
    }
    // æµè¯
    public static void main(String[] args) {
        System.out.println(Lazy01.getLazy().hashCode());
        System.out.println(Lazy01.getLazy().hashCode());
    }
}
```
## 4. ææ±å¼-02
éå¯¹ææ±å¼-01è¿è¡æ¹è¿ï¼å¯¹äºgetLazy02()æ¹æ³è¿è¡å éï¼ä½æ¯å¶å¼éæ¯è¾å¤§ï¼å ä¸ºæä»¬åªå¸æå¨åå»ºå¯¹è±¡çæ¶åå éï¼èéå¯¹æææ¥è·åå¯¹è±¡ççº¿ç¨è¿è¡å éï¼å½±åæçã
```java
package com.zyx.singleton;

// çº¿ç¨å®å¨ææ±å¼
public class Lazy02 {
    private static Lazy02 lazy02;

    private Lazy02(){

    }

    public synchronized static Lazy02 getLazy02() {
        if(lazy02 == null){
            lazy02 = new Lazy02();
        }
        return lazy02;
    }

    public static void main(String[] args) {
        System.out.println(Lazy02.getLazy02().hashCode());
        System.out.println(Lazy02.getLazy02().hashCode());
    }
}

```
## 5. ææ±å¼-03
éå¯¹ææ±å¼-02è¿è¡æ¹è¿ï¼å½åå»ºå¯¹è±¡æ¶æå éï¼ä½æ¯å½æAãBçº¿ç¨é½è¿å¥äº
if(lazy03 == null){} ä»£ç åä¸­ï¼å½Aåå»ºäºå¯¹è±¡ï¼æ­¤æ¶Bè·å¾äºéï¼ä¹ä¼è¿è¡å¯¹è±¡çåå»º
ï¼ä¸è½ä¿éçº¿ç¨å®å¨
```java
package com.zyx.singleton;

public class Lazy03 {
    private static Lazy03 lazy03;

    private Lazy03(){

    }

    public static Lazy03 getLazy03() {
        if(lazy03 == null){
            synchronized (Lazy03.class){
                lazy03 = new Lazy03();
            }
        }
        return lazy03;
    }

    public static void main(String[] args) {
        System.out.println(Lazy03.getLazy03().hashCode());
        System.out.println(Lazy03.getLazy03().hashCode());
    }
}
```
## 6. DCL
å¨å éæä½ä¸­ç»§ç»­å å¥å¤ç©ºæä½ï¼é²æ­¢å¯¹è±¡çéå¤åå»ºï¼å¹¶ä¸ä¸ºäºé¿åæä»¤éæé æçå½±åï¼å¯¹äºå¯¹è±¡å å¥volatileä¿è¯å¯è§æ§
```java
package com.zyx.singleton;

public class DCL {
    private static volatile DCL dcl;

    private DCL(){

    }

    public static DCL getDCL(){
        if(dcl == null){
            synchronized (DCL.class){
                if(dcl == null){
                    dcl = new DCL();
                }
            }
        }
        return dcl;
    }
}
```
## 7. éæåé¨ç±»
çº¿ç¨å®å¨ï¼åªæè°ç¨çæ¶åæä¼åå»ºåé¨ç±»ï¼å®ç°äºæå è½½æºå¶
```java
package com.zyx.singleton;

public class InnerClass {
    private InnerClass(){

    }
    private static class TempClass{
        private static final InnerClass innerClass = new InnerClass();
    }

    public static InnerClass getInnerClass(){
        return TempClass.innerClass;
    }
}

```
## 8. æä¸¾
æ æ³éè¿åå°ç ´è§£
```java
package com.zyx.singleton;

public enum EmuClass {
    INSTANCE;
}
```
