package room;

public class Window {
    public boolean isOpen;

    public Window(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void airCirculate() {
        if (isOpen) {
            System.out.println("The wind feels nice");
        } else {
            System.out.println("The window is closed. No circulation.");
        }
    }
}
