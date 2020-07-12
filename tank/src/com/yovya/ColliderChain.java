package com.yovya;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 7:11 AM
 * @Description: com.yovya
 * if chain implements Collider, pass in a chain, chain.
 * @version: 1.0
 */
public class ColliderChain implements Collider {
    List<Collider> colliders = new LinkedList<>();

    ColliderChain() {
        String[] cs = PropertyMgr.getProperties("colliders").split(",");
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

    void addCollider(Collider collider) {
        colliders.add(collider);
    }

    public boolean doCollide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (colliders.get(i).doCollide(o1, o2)) {
                return false;
            }
        }
        return true;
    }

}
