package com.codenotfound.crnk.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.crnk.core.engine.registry.RegistryEntry;
import io.crnk.core.engine.registry.ResourceRegistry;
import io.crnk.spring.boot.v3.CrnkConfigV3;

@RestController
@Import({CrnkConfigV3.class})
public class BlogRestController {

  @Autowired
  private ResourceRegistry resourceRegistry;

  @RequestMapping("/resources-info")
  public Map<String, String> getResources() {
    Map<String, String> result = new HashMap<>();
    // Add all resources
    for (RegistryEntry entry : resourceRegistry.getResources()) {
      result.put(entry.getResourceInformation().getResourceType(),
          resourceRegistry.getResourceUrl(entry.getResourceInformation()));
    }
    return result;
  }
}
