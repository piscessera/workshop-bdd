package com.workshop.bdd;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ContentService {
    private ContentDao contentDao;

    public ContentDao getContentDao() {
        return contentDao;
    }

    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    public List<ContentModel> findIONFlixContents(UserRequest request) {
        List<ContentModel> result = contentDao.getAll();

        result = result.stream()
                .filter(content -> Arrays.asList(content.getTag()).contains("ionflix"))
                .filter(content -> {
                    long diffInMillsec = request.getWatchingDate().getTime() - content.getCreatedDate().getTime();
                    long diff = TimeUnit.DAYS.convert(diffInMillsec, TimeUnit.MILLISECONDS);
                    if (diff < 30 && diff >= 0) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        result.sort((ContentModel c1, ContentModel c2) -> c2.getViewStat().compareTo(c1.getViewStat()));

        return result;
    }
}
