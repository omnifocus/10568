package com.yovya;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 9:03 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TestColliderChain implements Collider {
    List<Collider> colliders = new LinkedList<>();

    TestColliderChain() {
        String[] cs = PropertyMgr.getProperties("testColliderChain").split(",");
        for (String c : cs) {
            try {
                Collider collider = (Collider) Class.forName(c).getDeclaredConstructor().newInstance();
                addCollider(collider);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void addCollider(Collider collider) {
        this.colliders.add(collider);
    }

    @Override
    public boolean doCollide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).doCollide(o1, o2)) return false;
        }
        return true;
    }
}
