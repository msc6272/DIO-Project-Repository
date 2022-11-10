package dio.quebec.feign2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="agenda", url="https://msc6272-dio-project-repository-j4995p4xxqxhq9pv-8080.preview.app.github.dev/contato")
public interface ConsumindoApi {
    @RequestMapping(method= RequestMethod.GET, value="/")
    Contato retornaContato();
}
