package com.example.AgriculturalWarehouseManagement.Backend.services.bloger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service

public class BlogCleanupService {

    private final BlogService blogService;

    public BlogCleanupService(BlogService blogService) {
        this.blogService = blogService;
    }

    // Chạy mỗi ngày lúc 3 giờ sáng
    @Scheduled(cron = "0 0 3 * * ?")
    public void cleanOldDeletedBlogs() {
        blogService.deletePermanentlyBlogsOver30Days();
    }
}
