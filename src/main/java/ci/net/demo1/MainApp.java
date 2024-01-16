package ci.net.demo1;

import ci.net.demo1.models.entities.Role;
import ci.net.demo1.models.entities.Site;
import ci.net.demo1.models.repos.RoleRepo;
import ci.net.demo1.models.repos.SiteRepo;
import ci.net.demo1.models.repos.UserRepo;
import ci.net.demo1.models.entities.User;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        RoleRepo roleRepo = new RoleRepo();
        SiteRepo siteRepo = new SiteRepo();

        // create some courses
        Role role = new Role("admin");
        Role role1 = new Role("technicien");
        roleRepo.create(role);
        roleRepo.create(role1);

        Site site = new Site("Sud");
        Site site1 = new Site("Centre");
        Site site2 = new Site("Nord");
        siteRepo.create(site);
        siteRepo.create(site1);
        siteRepo.create(site2);

    }
}
