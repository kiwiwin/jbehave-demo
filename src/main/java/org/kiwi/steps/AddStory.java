package org.kiwi.steps;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddStory extends JUnitStories {
    @Override
    public Configuration configuration() {
        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
                .withDefaultFormats()
                .withFormats(Format.CONSOLE, Format.TXT, Format.XML, Format.HTML);
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromURL())
                .useStoryReporterBuilder(reporterBuilder);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new AddSteps());
    }

    @Override
    protected List<String> storyPaths() {
        try {
            List<String> files = new ArrayList<String>();
            URL storiesUrl = getClass().getClassLoader().getResource("org/kiwi/stories");
            assert storiesUrl != null;
            File[] stories = new File(storiesUrl.toURI()).listFiles();
            System.out.println(getClass().getClassLoader().getResource("org/kiwi/stories"));
            assert stories != null;
            for (File f: stories) {
                files.add(f.toURI().toString());
            }
            return files;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}