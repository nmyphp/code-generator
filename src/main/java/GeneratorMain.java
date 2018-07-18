import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * 代码生成器
 * 
 * @author chenlongjs
 */
public class GeneratorMain {
    /**
     * 请直接修改以下代码调用不同的方法以执行相关生成任务.
     */
    public static void main(String[] args) throws Exception {
        // 打印数据库中的表名称["TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM"]]
        // GeneratorFacade.printAllTableNames();
        GeneratorFacade g = new GeneratorFacade();
        String templatePath = GeneratorMain.class.getClassLoader().getResource("template").getPath();
        g.getGenerator().setTemplateRootDir(templatePath);
        // 删除上次生成的文件
        g.deleteOutRootDir();
        // 生成多个表需要写多条下面语句
        g.generateByTable("cooperation_image_map");
        // 自动搜索数据库中的所有表并生成文件,template为模板的根目录
        // 会将系统表、系统视图、视图、临时表等全部生成
        // g.generateByAllTable("template");
    }
}
