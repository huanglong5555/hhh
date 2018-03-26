package designMode.adapterPattern;

/**
 * 原有类的逻辑不能改的情况下 业务接口改变了 需要对买提供新的接口 使用适配器模式 继承新的接口 和原有的类
 * 
 * @author huanglong
 *
 */
public class ThreeHeadCharge extends TwoHeadCharge implements Charge {

	@Override
	public void doThreeHeadCharge() {
		System.out.println("将三孔插座转换成二孔插座！");
		doTwoHeadCharge();
	}

}
