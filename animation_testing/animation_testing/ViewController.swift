//
//  ViewController.swift
//  animation_testing
//
//  Created by Reid Pritchard on 10/7/21.
//

import UIKit

class ViewController: UIViewController {
    var show_animation = false
    var rec_view: UIView!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        rec_view = UIView(frame: CGRect(x: 0, y: 0, width: 100, height: 100))
        rec_view.backgroundColor = .systemRed
        view.addSubview(rec_view)
        rec_view.center = self.view.center
        rec_view.layer.cornerRadius = 15
        
        let scale_down = CGAffineTransform(scaleX: 0.5, y: 0.5)
        let rotate = CGAffineTransform(rotationAngle: CGFloat(90))
        let animationOptions = UIView.AnimationOptions.curveEaseInOut
        let options = UIView.KeyframeAnimationOptions(rawValue: animationOptions.rawValue)

        UIView.animateKeyframes(withDuration: 1, delay: 0.5, options: [.autoreverse, .repeat, options], animations: {
            UIView.addKeyframe(withRelativeStartTime: 0.0, relativeDuration: 1, animations: {
                self.rec_view.transform = scale_down
            })
            
            UIView.addKeyframe(withRelativeStartTime: 0.5, relativeDuration: 0.5, animations: {
                self.rec_view.transform = rotate
            })
        }, completion: nil)
    }

    @IBAction func button_pressed(_ sender: Any) {
        toggle_animation()
    }
    
    func toggle_animation() {
        rec_view.isHidden = !show_animation
        show_animation.toggle()
        show_animation ? pauseLayer(layer: rec_view.layer) : resumeLayer(layer: rec_view.layer)
    }
    
    // https://stackoverflow.com/questions/33994520/how-to-pause-and-resume-uiview-animatewithduration
    func pauseLayer(layer: CALayer) {
        let pausedTime: CFTimeInterval = layer.convertTime(CACurrentMediaTime(), from: nil)
        layer.speed = 0.0
        layer.timeOffset = pausedTime
    }

    func resumeLayer(layer: CALayer) {
        let pausedTime: CFTimeInterval = layer.timeOffset
        layer.speed = 1.0
        layer.timeOffset = 0.0
        layer.beginTime = 0.0
        let timeSincePause: CFTimeInterval = layer.convertTime(CACurrentMediaTime(), from: nil) - pausedTime
        layer.beginTime = timeSincePause
    }
    
}

