package com.ruoyi.web.controller.broad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cx
 * @Time 2019/10/26 15:19
 * @Description
 */
@Controller
@RequestMapping("/broad/camera")
public class BroadCameraController {
    private String prefix = "broad/camera";

    @GetMapping()
    public String pannel() {
        return prefix + "/camera";
    }

}
