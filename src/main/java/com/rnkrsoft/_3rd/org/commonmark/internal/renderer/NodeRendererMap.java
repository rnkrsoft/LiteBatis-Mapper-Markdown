package com.rnkrsoft._3rd.org.commonmark.internal.renderer;

import com.rnkrsoft._3rd.org.commonmark.node.Node;
import com.rnkrsoft._3rd.org.commonmark.renderer.NodeRenderer;

import java.util.HashMap;
import java.util.Map;

public class NodeRendererMap {

    private final Map<Class<? extends Node>, NodeRenderer> renderers = new HashMap<Class<? extends Node>, NodeRenderer>(32);

    public void add(NodeRenderer nodeRenderer) {
        for (Class<? extends Node> nodeType : nodeRenderer.getNodeTypes()) {
            // Overwrite existing renderer
            renderers.put(nodeType, nodeRenderer);
        }
    }

    public void render(Node node) {
        NodeRenderer nodeRenderer = renderers.get(node.getClass());
        if (nodeRenderer != null) {
            nodeRenderer.render(node);
        }
    }
}
