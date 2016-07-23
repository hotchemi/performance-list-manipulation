package performance.list;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.List;

import ix.Ix;
import rx.Observable;

final class ListUtils {

    private ListUtils() {
        throw new AssertionError();
    }

    static List<String> filter(List<String> arg) {
        List<String> result = new ArrayList<>();
        for (String str : arg) {
            if (str != null && str.startsWith("ok")) {
                result.add(str.toUpperCase());
            }
        }
        return result;
    }

    static List<String> filterStream(List<String> arg) {
        return Stream.of(arg)
                .filter(value -> value.startsWith("ok"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    static List<String> filterRx(List<String> arg) {
        return Observable.from(arg)
                .filter(value -> value.startsWith("ok"))
                .map(String::toUpperCase)
                .toList()
                .toBlocking()
                .single();
    }

    static List<String> filterIx(List<String> arg) {
        return Ix.from(arg)
                .filter(value -> value.startsWith("ok"))
                .map(String::toUpperCase)
                .toList()
                .single();
    }
}
