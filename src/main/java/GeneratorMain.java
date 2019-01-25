import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * 代码生成器
 */
public class GeneratorMain {

    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().setTemplateRootDir(getTemplateDir());
        g.deleteOutRootDir();
        g.generateByTable("order");
    }

    /**
     * 获取模板路径
     */
    protected static String getTemplateDir() {
        return GeneratorMain.class.getClassLoader().getResource("template").getPath();
    }
}
