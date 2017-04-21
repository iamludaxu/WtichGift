package gift.witch.dev.install;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

public final class AppManager {


    /**
     *
     * 检查是否安装过应用
     *
     * @param context
     * @param packageName
     * @return
     */
    public final static boolean isIntalled(Context context, String packageName) {
        boolean exist = false;
        if(context == null || TextUtils.isEmpty(packageName)){
            return exist;
        }
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfoList) {
            Log.e("AppManager",resolveInfo.activityInfo.packageName.toString());
            if (resolveInfo.activityInfo.packageName.equals(packageName)) {
                exist = true;
            }
        }
        return exist;
    }


    /**
     *
     * 卸载应用
     *
     * @param context
     * @param packageName 包名
     * @return
     */
    public final static boolean uninstall(Context context,String packageName){
        if(context == null || TextUtils.isEmpty(packageName)){
            return false;
        }
        Intent intent = new Intent();
        Uri uri = Uri.parse("package:"+packageName);//获取删除包名的URI
        intent.setAction(Intent.ACTION_DELETE);//设置我们要执行的卸载动作
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(uri);//设置获取到的URI
        context.startActivity(intent);
        return true;
    }

    /**
     *
     * 启动其他应用
     *
     * @param context
     * @param packageName
     * @return
     */
    public final static boolean launchIntentForPackage(Context context,String packageName){
        if(context == null || TextUtils.isEmpty(packageName)){
            return false;
        }
        PackageManager pm = context.getPackageManager();
        Intent i = pm.getLaunchIntentForPackage(packageName);//获取启动的包名
        context.startActivity(i);
        return true;
    }



}
