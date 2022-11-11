package dio.quebec.BeansComponents.app;

@FunctionalInterface
public interface CommandLineRunner {
    void run(String... args) throws Exception;
}
