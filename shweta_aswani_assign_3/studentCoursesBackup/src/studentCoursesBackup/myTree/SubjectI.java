package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;

public interface SubjectI {
   
    public void registerOrDregisterObserver(Node obs, String value);

    public void notifyAll(String course);
}