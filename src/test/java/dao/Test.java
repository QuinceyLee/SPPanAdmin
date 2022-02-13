package dao;

import net.sppan.base.Application;
import net.sppan.base.entity.AttackedMsg;
import net.sppan.base.service.data.IAttackedMsgService;
import net.sppan.base.service.system.IResourceService;
import net.sppan.base.service.system.IRoleService;
import net.sppan.base.service.system.IUserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.tablesaw.api.Table;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test
{

    @Resource
    IRoleService iRoleService;

    @Resource
    IUserService iUserService;

    @Resource
    IResourceService iResourceService;

    @Resource
    IAttackedMsgService iAttackedMsgService;

    @org.junit.Test
    public void test(){
        Page<AttackedMsg> all = iAttackedMsgService.findAll(new PageRequest(0, 2));
        System.out.println(all.getContent().get(0));
    }


    @org.junit.Test
    public void testSaw() throws IOException {

        Table robberies = Table.read().csv("./data/boston-robberies.csv");

//
//        Plot.show(
//
//                AreaPlot.create(
//
//                        "Boston Robberies by month: Jan 1966-Oct 1975",
//
//                        robberies, "Record", "Robberies"));

    }
}
