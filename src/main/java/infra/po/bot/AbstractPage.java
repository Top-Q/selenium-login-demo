package infra.po.bot;

public abstract class AbstractPage {

    protected final ActionBot bot;

    public AbstractPage(ActionBot bot) {
        this.bot = bot;
    }

}
