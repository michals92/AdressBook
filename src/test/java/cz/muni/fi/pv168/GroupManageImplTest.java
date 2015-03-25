package cz.muni.fi.pv168;

import junit.framework.TestCase;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class GroupManageImplTest extends TestCase {

    GroupManager manager;

    /**
     * tests that remove of one group does not affect another group
     * @throws Exception
     */

    @Test
    public void testRemoveGroup() throws Exception {
        Group group = new Group("test");
        Group group2 = new Group("test2");

        group = manager.createGroup(group);
        group2 = manager.createGroup(group2);

        manager.removeGroup(group);
        assertThat(manager.getGroups(), not(CoreMatchers.hasItem(group)));
        assertNull(manager.getGroup(group.getId()));

        assertDeepEquals(group2, manager.getGroup(group2.getId()));
    }

    private void assertDeepEquals(Group expected, Group result) {
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getName(), result.getName());
    }

    /**
     * tests correct return of group list
     * @throws Exception
     */
    @Test
    public void testGetGroups() throws Exception {
        Group group = new Group("test");
        Group group2 = new Group("test2");

        group = manager.createGroup(group);
        group2 = manager.createGroup(group2);


        List<Group> expected = Arrays.asList(group, group2);
        List<Group> result = manager.getGroups();

        assertNotNull(result);
        assertThat(result, CoreMatchers.hasItem(group));
        assertThat(result, CoreMatchers.hasItem(group2));
    }


    /**
     * tests remove of null group
     * @throws Exception
     */

    @Test
    public void testRemoveGroupWithNull() throws Exception {
        try {
            manager.removeGroup(null);
            fail("deleted null group");
        } catch(NullPointerException e) {}
    }
}