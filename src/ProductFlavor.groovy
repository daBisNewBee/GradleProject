class ProductFlavor {

    private int mVersionCode
    private String mVersionName
    private int mMinSdkVersion
    private int mTargetSdkVersion

    def versionCode(int vc){
        mVersionCode = vc
    }

    def versionName(String vn) {
        mVersionName = vn
    }

    def minSdkVersion(int mv){
        mMinSdkVersion = mv
    }

    def targetSdkVersion(int tsv){
        mTargetSdkVersion = tsv
    }


    @Override
    public String toString() {
        return "ProductFlavor{" +
                "mVersionCode=" + mVersionCode +
                ", mVersionName='" + mVersionName + '\'' +
                ", mMinSdkVersion=" + mMinSdkVersion +
                ", mTargetSdkVersion=" + mTargetSdkVersion +
                '}';
    }
}
